package com.ccitsoft.designer.singleton;

/**
 * <p>Description: [多线程情况下单例]</p>
 * Created on 2018年1月17日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class SingletonPattern {

	private static SingletonPattern singletonPattern = new SingletonPattern();
	
	private SingletonPattern(){}
	
	public synchronized static SingletonPattern getInstance(){
		return singletonPattern;
	}
}
