package com.iotNM.common;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

import com.iotNM.entity.reg.NET;
import com.iotNM.entity.reg.NODE;
import com.iotNM.entity.reg.SENSOR;
import com.iotNM.entity.reg.SUBNET;
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
	
	public static byte[] JAVA_Register_NET(NET aNetMsg)throws NativeException {
		  
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
			javaCallDll.JAVA_Register_NET(new NET());
		} catch (NativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static byte[] JAVA_Register_SubNet(SUBNET asubNetMsg)throws NativeException {
		  JNative.setLoggingEnabled(true);  
	        try {  
	            JNative getUrl = new JNative("C:\\IOTRegServiceDll.dll", "NetRegMessageBuilder"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
	            Pointer returnPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
	            getUrl.setRetVal(Type.INT); //设置返回值类型为：String  
	            getUrl.setParameter(0, asubNetMsg.getnNetId()); //按顺序设置方法需要的参数值  
	            getUrl.setParameter(1, asubNetMsg.getnSubnetId());  
	            getUrl.setParameter(2, asubNetMsg.getStrSubnetName()); 
	            getUrl.setParameter(3, asubNetMsg.getStrSubnetDescrption());  
	            getUrl.setParameter(4, asubNetMsg.getStrSinkIp());  
	            getUrl.setParameter(5, asubNetMsg.getnChannel());  
	            getUrl.setParameter(6, asubNetMsg.getnWorkCycle());  
	            getUrl.setParameter(7, asubNetMsg.getStrAcsMethodName());  
	            getUrl.setParameter(8, asubNetMsg.getStrMemo());
	            getUrl.setParameter(9,  Type.FLOAT, String.valueOf(asubNetMsg.getfCvrg_LB_X())); 
	            getUrl.setParameter(10,  Type.FLOAT, String.valueOf(asubNetMsg.getfCvrg_LB_Y()));  
	            getUrl.setParameter(11,  Type.FLOAT, String.valueOf(asubNetMsg.getfCvrg_RU_X()));
	            getUrl.setParameter(12, Type.FLOAT, String.valueOf(asubNetMsg.getfCvrg_RU_Y()));            
	            getUrl.setParameter(13, asubNetMsg.getnAppId()); 
	            getUrl.setParameter(14, returnPointer);
	            getUrl.invoke(); //调用方法
	            byte[] getBytes=returnPointer.getMemory();
	            System.out.println(getUrl.getRetVal()); //输出返回值
	            return getBytes; 
	        } catch (IllegalAccessException e) {  
	            e.printStackTrace();  
	            return null;
	        }
	}

	public static byte[] JAVA_Register_Node(NODE anodeMsg) throws NativeException{
		JNative.setLoggingEnabled(true);  
        try {  
            JNative getUrl = new JNative("C:\\IOTRegServiceDll.dll", "NetRegMessageBuilder"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
            Pointer returnPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String  
            getUrl.setParameter(0, anodeMsg.getStrDsption()); //按顺序设置方法需要的参数值  
            getUrl.setParameter(1, anodeMsg.getnNodeAddr());  
            getUrl.setParameter(2, anodeMsg.getStrProducer()); 
            getUrl.setParameter(3, anodeMsg.getStrVersion());  
            getUrl.setParameter(4, anodeMsg.getnTransPower());  
            getUrl.setParameter(5, anodeMsg.getStrMemo());  
            getUrl.setParameter(6, Type.FLOAT, String.valueOf(anodeMsg.getfLctnX()));  
            getUrl.setParameter(7, Type.FLOAT, String.valueOf(anodeMsg.getfLctnY()));  
            getUrl.setParameter(8, anodeMsg.getnNetId());
            getUrl.setParameter(9,  anodeMsg.getnSubnetId()); 
            getUrl.setParameter(10,  anodeMsg.getnNodeTypeId());  
            getUrl.setParameter(11,  anodeMsg.getnAppId());
            getUrl.setParameter(12, returnPointer);
            getUrl.invoke(); //调用方法
            byte[] getBytes=returnPointer.getMemory();
            System.out.println(getUrl.getRetVal()); //输出返回值
            return getBytes; 
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
            return null;
        }
	}

	public static byte[] JAVA_Register_Sensor(SENSOR asensorMsg)throws NativeException {
		JNative.setLoggingEnabled(true);  
        try {  
            JNative getUrl = new JNative("C:\\IOTRegServiceDll.dll", "NetRegMessageBuilder"); //创建 getUrl 方法的<span style="font-family: Arial, Helvetica, sans-serif;">JNative对象</span>  
            Pointer returnPointer=new Pointer(MemoryBlockFactory.createMemoryBlock(1024));
            getUrl.setRetVal(Type.INT); //设置返回值类型为：String  
            getUrl.setParameter(0, asensorMsg.getStrSensorName()); //按顺序设置方法需要的参数值  
            getUrl.setParameter(1, asensorMsg.getStrSenorDescription());  
            getUrl.setParameter(2, asensorMsg.getStrProducer()); 
            getUrl.setParameter(3, asensorMsg.getStrVersion());  
            getUrl.setParameter(4, asensorMsg.getStrUnit());  
            getUrl.setParameter(5, asensorMsg.getStrFormula());  
            getUrl.setParameter(6, asensorMsg.getStrPrms());  
            getUrl.setParameter(7, asensorMsg.getStrMax());  
            getUrl.setParameter(8, asensorMsg.getStrMin());
            getUrl.setParameter(9, asensorMsg.getStrPrecision()); 
            getUrl.setParameter(10, asensorMsg.getnSensorType());  
            getUrl.setParameter(11, asensorMsg.getnAppId());
            getUrl.setParameter(12, returnPointer);
            getUrl.invoke(); //调用方法
            byte[] getBytes=returnPointer.getMemory();
            System.out.println(getUrl.getRetVal()); //输出返回值
            return getBytes; 
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
            return null;
        }
	}
}
