package com.iotNM.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jdom.Document;  
import org.jdom.Element;  
import org.jdom.input.SAXBuilder;  
  

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;



/**
 * 简单封装Jackson，实现JSON String<->Java Object的Mapper.
 * 
 * 封装不同的输出风格, 使用不同的builder函数创建实例.
 * 
 * 
 */
public class JsonMapper {

	private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);
	 private static ObjectMapper objectMapper = new ObjectMapper();  
	

	private ObjectMapper mapper;

	public JsonMapper() {
        this(null);
    }
	
    public JsonMapper(Include include) {
		mapper = new ObjectMapper();
		//设置输出时包含属性的风格
        if (include != null) {
            mapper.setSerializationInclusion(include);
        }
        //设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
    /** 
     * 转换一个xml格式的字符串到json格式 
     *  
     * @param xml 
     *            xml格式的字符串 
     * @return 成功返回json 格式的字符串;失败反回null 
     */  
    @SuppressWarnings("unchecked")  
    public static  String xml2JSON(String xml) {  
        JSONObject obj = new JSONObject();  
        try {  
            InputStream is = new ByteArrayInputStream(xml.getBytes("GB2312"));  
            SAXBuilder sb = new SAXBuilder();  
            Document doc = sb.build(is);  
            Element root = doc.getRootElement();  
            obj.put(root.getName(), iterateElement(root));  
            return obj.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    /** 
     * 一个迭代方法  
     */  
    @SuppressWarnings("unchecked")  
    private static Map<String, List>  iterateElement(Element element) {  
        List<?> jiedian = element.getChildren();  
        Element et = null;  
        Map<String, List> obj = new HashMap<String, List>();  
        List<Object> list = null;  
        for (int i = 0; i < jiedian.size(); i++) {  
            list = new LinkedList<Object>();  
            et = (Element) jiedian.get(i);  
            if (et.getTextTrim().equals("")) {  
                if (et.getChildren().size() == 0)  
                    continue;  
                if (obj.containsKey(et.getName())) {  
                    list = (List<Object>) obj.get(et.getName());  
                }  
                list.add(iterateElement(et));  
                obj.put(et.getName(), list);  
            } else {  
                if (obj.containsKey(et.getName())) {  
                    list = (List<Object>) obj.get(et.getName());  
                }  
                list.add(et.getTextTrim());  
                obj.put(et.getName(), list);  
            }  
        }  
        return obj;  
    }  
    /**
	 * 创建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper,建议在外部接口中使用.
	 */
	public static JsonMapper nonEmptyMapper() {
		return new JsonMapper(Include.NON_EMPTY);
	}

	/**
	 * 创建只输出初始值被改变的属性到Json字符串的Mapper, 最节约的存储方式，建议在内部接口中使用。
	 */
	public static JsonMapper nonDefaultMapper() {
		return new JsonMapper(Include.NON_DEFAULT);
	}
	
	/**
	 * Object可以是POJO，也可以是Collection或数组。
	 * 如果对象为Null, 返回"null".
	 * 如果集合为空集合, 返回"[]".
	 */
    public String toJson(Object object) {

        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            logger.warn("write to json string error:" + object, e);
            return null;
        }
    }
    
    /**
     * 输出JSONP格式数据.
     */
    public String toJsonP(String functionName, Object object) {
        return toJson(new JSONPObject(functionName, object));
    }

	/**
	 * 如果JSON字符串为Null或"null"字符串,返回Null.
	 * 如果JSON字符串为"[]",返回空集合.
	 * 
	 * 如需读取集合如List/Map,且不是List<String>这种简单类型时使用如下语句:
	 * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {});
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}
	
	/**
	 * 反序列化复杂Collection如List<Bean>, 先使用函數createCollectionType构造类型,然后调用本函数.
	 * @see #createCollectionType(Class, Class...)
	 */
	public <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return (T) mapper.readValue(jsonString, javaType);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}
	
    
    /**
     * 構造泛型的Collection Type如:
     * ArrayList<MyBean>, 则调用constructCollectionType(ArrayList.class,MyBean.class)
     * HashMap<String,MyBean>, 则调用(HashMap.class,String.class, MyBean.class)
     */
    public JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 當JSON裡只含有Bean的部分屬性時，更新一個已存在Bean，只覆蓋該部分的屬性.
     */
    @SuppressWarnings("unchecked")
    public <T> T update(String jsonString, T object) {
        try {
            return (T) mapper.readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException e) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        } catch (IOException e) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        }
        return null;
    }
    
    /**
	 * 設定是否使用Enum的toString函數來讀寫Enum,
	 * 為False時時使用Enum的name()函數來讀寫Enum, 默認為False.
	 * 注意本函數一定要在Mapper創建後, 所有的讀寫動作之前調用.
	 */
	public void enableEnumUseToString() {
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	}

	/**
	 * 支持使用Jaxb的Annotation，使得POJO上的annotation不用与Jackson耦合。
	 * 默认会先查找jaxb的annotation，如果找不到再找jackson的。
	 */
	public void enableJaxbAnnotation() {
		JaxbAnnotationModule module = new JaxbAnnotationModule();
		mapper.registerModule(module);
	}

	/**
	 * 取出Mapper做进一步的设置或使用其他序列化API.
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}
}
