package com.iotNM.tests;

public class byteConvert {
	/** 
     * byte������ȡint��ֵ��������������(��λ��ǰ����λ�ں�)��˳��
     *  
     * @param ary 
     *            byte���� 
     * @param offset 
     *            ������ĵ�offsetλ��ʼ 
     * @return int��ֵ 
     */  
	public static int bytesToInt(byte[] ary, int offset) {
		int value;	
		value = (int) ((ary[offset]&0xFF) 
				| ((ary[offset+1]<<8) & 0xFF00)
				| ((ary[offset+2]<<16)& 0xFF0000) 
				| ((ary[offset+3]<<24) & 0xFF000000));
		return value;
	}
	/**
	 * byte[]תshort
	 * @Title: bytesToShort 
	 * @Description: TODO
	 * @param @param ary
	 * @param @param offset
	 * @param @return    ����
	 * @return int    �������� 
	 * @throws
	 */
	public static short bytesToShort(byte[] ary, int offset) {
		short value;	
		value = (short) ((ary[offset]&0xFF) 
				| ((ary[offset+1]<<8) & 0xFF00));
		return value;
	}
	 /** 
     * 整型转换为4位字节数组 
     * @param intValue 
     * @return 
     */  
    public static byte[] int2Byte(int intValue) {  
        byte[] b = new byte[4];  
        for (int i = 0; i < 4; i++) {  
            b[i] = (byte) (intValue >> 8 * (3 - i) & 0xFF);  
            //System.out.print(Integer.toBinaryString(b[i])+" ");  
            //System.out.print((b[i] & 0xFF) + " ");  
        }  
        return b;  
    }
    public static void main(String[] args) {
		
    	byte[] inputMsg={1, 0, 0, 0, }	;
    	bytesToInt(inputMsg, 0);
	}
}
