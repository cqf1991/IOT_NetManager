package com.iotNM.tests;

import org.springframework.stereotype.Service;
/*
 * 接口实现
 */
@Service
public class AOPtest implements AOPtestInterface {

	@Override
	public void save(String name) {
		System.out.println("I'm SAVE");
	}
	@Override
	public void update(String name, Integer id) {
		System.out.println("I'm update");

	}
}
