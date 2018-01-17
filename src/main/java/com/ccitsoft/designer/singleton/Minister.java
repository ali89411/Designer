package com.ccitsoft.designer.singleton;

/**
 * <p>Description: [定义大臣类，访问是同一个皇帝对象]</p>
 * Created on 2018年1月17日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Minister {

	public static void main(String[] args) {
		//第一天
		Emperor.getInstance().emperorInfo();
		//第二天
		Emperor.getInstance().emperorInfo();
		//第三天
		Emperor.getInstance().emperorInfo();
	}
}
