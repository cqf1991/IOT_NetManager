package com.iotNM.common;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

import com.iotNM.entity.reg.NET;
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
	
	public static byte[] JAVA_Register(NET aNetMsg)throws NativeException {
		  
        JNative.setLoggingEnabled(true);  
        try {  
            JNative getUrl = new JNative("C:\\IOTRegServiceDll.dll", "NetRegMessageBuilder"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
            Pointer returnPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String  
            getUrl.setParameter(0, aNetMsg.getStrNetName()); //按顺序设置方法需要的参数值  
            getUrl.setParameter(1, aNetMsg.getStrNetDescrption());  
            getUrl.setParameter(2, aNetMsg.getStrAddress()); 
            getUrl.setParameter(3, aNetMsg.getStrOrganUnit());  
            getUrl.setParameter(4, aNetMsg.getStrRepUnit());  
            getUrl.setParameter(5, aNetMsg.getStrLinkMan());  
            getUrl.setParameter(6, aNetMsg.getStrPhone());  
            getUrl.setParameter(7, aNetMsg.getStrMemo());  
            getUrl.setParameter(8, Type.FLOAT, String.valueOf(aNetMsg.getfCvrg_LB_X())) ;
            getUrl.setParameter(9,  Type.FLOAT, String.valueOf(aNetMsg.getfCvrg_LB_Y())); 
            getUrl.setParameter(10,  Type.FLOAT, String.valueOf(aNetMsg.getfCvrg_RU_X()));  
            getUrl.setParameter(11,  Type.FLOAT, String.valueOf(aNetMsg.getfCvrg_RU_Y()));  
            getUrl.setParameter(12, aNetMsg.getnAppId());  //appid            
            getUrl.setParameter(13, returnPointer); //returnpointer输出给cis  byte[]  
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
			javaCallDll.JAVA_Register(new NET());
		} catch (NativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
