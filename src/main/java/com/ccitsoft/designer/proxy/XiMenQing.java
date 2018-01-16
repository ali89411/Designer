package com.ccitsoft.designer.proxy;

/**
 * <p>Description: [定义执行对象类]</p>
 * Created on 2018年1月16日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class XiMenQing {

	/*
	* 水浒里是这样写的：西门庆被潘金莲用竹竿敲了一下难道，痴迷了，
	* 被王婆看到了, 就开始撮合两人好事，王婆作为潘金莲的代理人
	* 收了不少好处费，那我们假设一下：
	* 如果没有王婆在中间牵线，这两个不要脸的能成吗？难说的很！
	*/
	public static void main(String[] args) {
		//把王婆叫出来
		WangPo wangPo = new WangPo();
		//虽然表面上时王婆在做，实际上是潘金莲
		wangPo.makeEyesWithMan();
		wangPo.happyWithMan();
		
		// 王婆代理KindWomenB对象
		KindWomenB kindWomenB = new KindWomenB();
		WangPo wangPo1 = new WangPo(kindWomenB);
		wangPo1.makeEyesWithMan();
		wangPo1.happyWithMan();
	}
}
