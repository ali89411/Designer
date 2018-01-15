package com.ccitsoft.designer.strategy;

/**
 * <p>Description: [计谋有了，需要锦囊容器]</p>
 * Created on 2018年1月15日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Context {

	// 构造函数，你要使用那个妙计
	private IStrategy straegy;

	public Context(IStrategy strategy) {
		this.straegy = strategy;
	}
	
	/**
	 * <p>Discription:[使用锦囊]</p>
	 * Created on 2018年1月15日
	 * @author:[ali]
	 */
	public void operate(){
		this.straegy.operate();
	}
}
