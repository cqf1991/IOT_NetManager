package com.iotNM.common;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

import com.iotNM.tests.byteConvert;

public class javaCallDll {
	public static String dllPath="C:\\ClientDll.dll";
	
	
	public static byte[] JAVA_GetDirData()throws NativeException {
				  
        JNative.setLoggingEnabled(true);  
        try {  
            JNative getUrl = new JNative("C:\\ClientDll.dll", "JAVA_GetDirData"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
            Pointer returnPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
            getUrl.setRetVal(Type.VOID); //设置返回值类型为：String  
            getUrl.setParameter(0, 49); //按顺序设置方法需要的参数值  
            getUrl.setParameter(1, 2);  
            getUrl.setParameter(2, 6); 
            getUrl.setParameter(3, -1);  
            getUrl.setParameter(4, -1);  
            getUrl.setParameter(5, -1);  
            getUrl.setParameter(6, -1);  
            getUrl.setParameter(7, returnPointer);   
            getUrl.invoke(); //调用方法
            byte[] getBytes=returnPointer.getMemory();
            System.out.println(getUrl.getRetVal()); //输出返回值
            return getBytes; 
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
            return null;
        }
        
	}
	
	public static byte[] JAVA_Register()throws NativeException {
		  
        JNative.setLoggingEnabled(true);  
        try {  
            JNative getUrl = new JNative("C:\\IOTRegServiceDll.dll", "NetRegMessageBuilder"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
            Pointer returnPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String  
            getUrl.setParameter(0, "NETNAME"); //按顺序设置方法需要的参数值  
            getUrl.setParameter(1, "strNetDescrption");  
            getUrl.setParameter(2, "strAddress"); 
            getUrl.setParameter(3, "strOrganUnit");  
            getUrl.setParameter(4, "strRepUnit");  
            getUrl.setParameter(5, "strLinkMan");  
            getUrl.setParameter(6, "strPhone");  
            getUrl.setParameter(7, "strMemo");  
            getUrl.setParameter(8, Type.FLOAT, "1.5") ;
            getUrl.setParameter(9,  Type.FLOAT, "1.5");  
            getUrl.setParameter(10,  Type.FLOAT, "1.5");  
            getUrl.setParameter(11,  Type.FLOAT, "1.5");  
            getUrl.setParameter(12, 49);              
            getUrl.setParameter(13, returnPointer);   
            getUrl.invoke(); //调用方法
            byte[] getBytes=returnPointer.getMemory();
            System.out.println(getUrl.getRetVal()); //输出返回值
            return getBytes; 
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
            return null;
        }
        
	}
	
	
	public static void main(String[] args) {
		try {
			javaCallDll.JAVA_Register();
		} catch (NativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
