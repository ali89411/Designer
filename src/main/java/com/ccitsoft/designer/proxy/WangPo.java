package com.ccitsoft.designer.proxy;
/**
 * <p>Description: [代理类]</p>
 * Created on 2018年1月16日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class WangPo implements KindWomen{
	

	KindWomen kinWomen;
	
	/**
	 * <p>Discription:[默认潘金莲代理]</p>
	 * @coustructor 方法.
	 */
	public WangPo(){
		this.kinWomen = new PanJinLian();
	}
	
	/**
	 * <p>Discription:[可以代理任何继承kindWomen接口人]</p>
	 * @coustructor 方法.
	 */
	public WangPo(KindWomen kinWomen){
		this.kinWomen = kinWomen;
	}
	
	
	/**
	 * <p>Discription:[被代理对象-makeEyesWithMan]</p>
	 * Created on 2018年1月16日
	 * @author:[ali]
	 */
	public void makeEyesWithMan() {
		this.kinWomen.makeEyesWithMan();
	}

	/**
	 * <p>Discription:[被代理对象-happyWithMan]</p>
	 * Created on 2018年1月16日
	 * @author:[ali]
	 */
	public void happyWithMan() {
		this.kinWomen.happyWithMan();
	}

}
