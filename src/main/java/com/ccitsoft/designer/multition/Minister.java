package com.ccitsoft.designer.multition;

/**
 * <p>Description: [定义大臣类]</p>
 * Created on 2018年1月17日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Minister {

	public static void main(String[] args) {
		for(int i=0 ; i< 100;i++){
			Emperor emperor = Emperor.getInstance();
			System.out.print("第"+(i+1)+"个大臣参拜的是： ");
			emperor.emperorInfo();
		}
	}
}
