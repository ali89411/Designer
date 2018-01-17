package com.ccitsoft.designer.multition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>Description: [定义皇帝]</p>
 * Created on 2018年1月17日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Emperor {

	/**
	 * 定义皇帝数量，最多有2个
	 */
	private static int maxNumberEmperor = 2;
	
	// 装皇帝对象的列表
	private static List<Emperor> emperorList = new ArrayList<Emperor>(maxNumberEmperor);
	
	// 装皇帝名字的列表
	private static List<String> emperorInfoList = new ArrayList<String>(maxNumberEmperor);
	
	private static int countNumOfEmperor = 0; //正在被人尊称的是那个皇帝
	
	static {
		//把所有的皇帝都产生出来
		for(int i = 0;i < maxNumberEmperor; i++){
		   emperorList.add(new Emperor("皇"+(i+1)+"帝"));
		}
	}
	
	//就这么多皇帝了，不允许再推举一个皇帝(new 一个皇帝）
	private Emperor(){
		
	}
	
	/**
	 * <p>Discription:[构造器方法描述]</p>
	 * @coustructor 方法.
	 */
	private Emperor(String info){
		emperorInfoList.add(info);
	}
	
	/**
	 * <p>Discription:[方法功能中文描述]</p>
	 * Created on 2018年1月17日
	 * @return
	 * @author:[ali]
	 */
	public static Emperor getInstance() {
		Random random = new Random();
		// 随机拉出一个皇帝，
		countNumOfEmperor = random.nextInt(maxNumberEmperor);
		// 只要是个精神领袖就成
		return (Emperor) emperorList.get(countNumOfEmperor);
	}

	// 皇帝叫什么名字呀
	public static void emperorInfo() {
		System.out.println(emperorInfoList.get(countNumOfEmperor));
	}
}
