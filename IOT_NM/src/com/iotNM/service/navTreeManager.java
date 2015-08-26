package com.iotNM.service;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.sf.json.JSON;

import org.springframework.stereotype.Service;

import com.iotNM.entity.xml.IOT_DIR;
import com.sun.xml.internal.bind.v2.TODO;


@Service
public class navTreeManager {

	public String generateTree(String comMsg) {//将xml转换为iot对象
		try {  
            JAXBContext context = JAXBContext.newInstance(IOT_DIR.class);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            IOT_DIR iot = (IOT_DIR)unmarshaller.unmarshal(new StringReader(comMsg));  
            System.out.println(iot.getNETS().getNETSIZE());
            String jsonTree=createJsonTree(iot); //TODO 生成json树并返回
            return jsonTree;
           
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
		return "false";
		
	}
	
	
	/**
	 * 第二个子网的第二个节点会出现bug，json少一个逗号，待修复
	 * @param iot
	 * @return
	 */
	private String createJsonTree(IOT_DIR iot) {

		String StrJson="[";
		// TODO 对象转换成json格式
		for(int i=0;i<iot.getNETS().getNET().size();i++)
	      {
		
			StrJson+="{text:'"+iot.getNETS().getNET().get(i).getNTID()+"号网络"+"',leaf:false,children:[";
			if(iot.getNETS().getNET().get(i).getSUBNET()!=null)
			for(int j=0;j<iot.getNETS().getNET().get(i).getSUBNET().size();j++)
			{
				
				StrJson+="{text:'"+iot.getNETS().getNET().get(i).getSUBNET().get(j).getSBNTID()+"号子网"+"',leaf:false,children:[";
				
				if(iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE()!=null)
				for(int k=0;k<iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE().size();k++)
				{
					StrJson+="{text:'"+iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE().get(k).getNDPHDR()+"号节点"+"',leaf:false,children:[";
					if(iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE().get(k).getSENSOR()!=null)
					for(int m=0;m<iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE().get(k).getSENSOR().size();m++)
					{
						StrJson+="{text:'"+iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE().get(k).getSENSOR().get(m).getSTPNM()+"传感器"+"',leaf:true,children:[";
						if(0==iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE().get(k).getSENSOR().size()-1)
	    					StrJson+="]}";
		    			else {
		    				StrJson+="]},";
						}
					}
					
					if(0==iot.getNETS().getNET().get(i).getSUBNET().get(j).getNODE().size()-1)
  					StrJson+="]}";
	    			else {
	    				StrJson+="]},";
					}
				}
				
				if(0==iot.getNETS().getNET().get(i).getSUBNET().size()-1)
					StrJson+="]}";
  			else {
  				StrJson+="]},";
				}
			}
			if(i==iot.getNETS().getNET().size()-1)
			StrJson+="]}";
			else {
				StrJson+="]},";
			}
	      }
	  
		StrJson+="]" ;
    
	return StrJson;
	}

}
