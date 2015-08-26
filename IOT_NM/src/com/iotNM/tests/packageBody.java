package com.iotNM.tests;

import java.util.Arrays;

/**
 * 
 * @ClassName: packageBody
 * @Description: ��Ԫ��������
 * @author ���� cqf1324@vip.qq.com
 * @date 2015-1-20 ����9:45:04
 */
public class packageBody {
	short valueSize;
	String keyName;
	String keyValue;

	public packageBody(byte[] packagebody, int keyNum) {
		valueSize = byteConvert.bytesToShort(packagebody, 0);
		keyName = new String(Arrays.copyOfRange(packagebody, 2, 12)).trim();
		byte[] doublesub = Arrays.copyOfRange(packagebody, 12,
				packagebody.length);
		//keyValue=;
		}
		// keyValue=new
		// String(String.valueOf(byteConvert.byteToDouble(doublesub)));


	public short getValueSize() {
		return valueSize;
	}

	public void setValueSize(short valueSize) {
		this.valueSize = valueSize;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

}
