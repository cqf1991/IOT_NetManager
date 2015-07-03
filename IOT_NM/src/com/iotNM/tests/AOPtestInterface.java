package com.iotNM.tests;

import org.springframework.stereotype.Service;

/*
 * 测试接口
 */
public interface AOPtestInterface {
	public void save(String name);

	public void update(String name, Integer id);
}
