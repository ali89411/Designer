package com.ccitsoft.designer.singleton;

/**
 * <p>Description: [中国的历史上一般都是一个朝代一个皇帝]</p>
 * Created on 2018年1月17日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Emperor {

	// 定义一个皇帝，赋予名字
	private static Emperor emperor = null;

	/**
	 * <p>Discription:[世俗和道德约束你，目的就是不让你产生第二个皇帝]</p>
	 * @coustructor 方法. 构造函数private修饰、
	 */
	private Emperor() {
		
	}
	
	/**
	 * <p>Discription:[提供接口实例化对象]</p>
	 * Created on 2018年1月17日
	 * @return
	 * @author:[ali]
	 */
	public static Emperor getInstance(){
		if(null == emperor){
			emperor = new Emperor();
		}
		return emperor;
	}
	
	/**
	 * <p>Discription:[定义皇帝名字]</p>
	 * Created on 2018年1月17日
	 * @author:[ali]
	 */
	public static void emperorInfo(){
		System.out.println("我就是皇帝朱元璋........");
	}
	
	public static void main(String[] args) {
		
	}
	
}
