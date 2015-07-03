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
	public static void JAVA_GetXMLData(byte[] msgFromDir,String filepath)
	{
		 JNative.setLoggingEnabled(true);  
	        try {  
	            JNative getUrl = new JNative(dllPath, "JAVA_GetXMLFile"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
	            Pointer srcDataPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
	            Pointer filePathPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
	            filePathPointer.setMemory(filepath.getBytes());
	            srcDataPointer.setMemory(msgFromDir);
	            getUrl.setRetVal(Type.INT); //设置返回值类型为：String  
	            getUrl.setParameter(0, srcDataPointer); //按顺序设置方法需要的参数值  
	            getUrl.setParameter(1, filePathPointer);   
	            getUrl.invoke(); //调用方法
	            System.out.println(getUrl.getRetVal()); //输出返回值
	        } catch (IllegalAccessException e) {  
	            e.printStackTrace();  
	        } catch (NativeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}
	
	public static byte[] JAVA_GetSubScribeData()throws NativeException {
		//TODO	获取数据包	  
        JNative.setLoggingEnabled(true);  
        try {  
            JNative getUrl = new JNative(dllPath, "JAVA_GetDirData"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
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
	public static void main(String[] args) {
		try {
			javaCallDll.JAVA_GetDirData();
		} catch (NativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
