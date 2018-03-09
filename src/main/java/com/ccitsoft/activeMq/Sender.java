package com.ccitsoft.activeMq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * <p>Description: [activeMQ--sender]</p>
 * Created on 2018年2月27日
 * @author  <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0 
 * Copyright (c) 2018 桑德环卫 云平台技术部
 */
public class Sender {
	
	public static void main(String[] args) throws Exception{
		// 1,建立工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				"tcp://localhost:61616");
		// 2,创建connection,打开连接
		Connection connection = connectionFactory.createConnection();
		connection.start();
		// 3,创建session---参数1,是否持久化，2,接受的方式
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		// 4,创建目标地址
		Destination destination = session.createQueue("queue1");
		// 5,创建发送者
		MessageProducer messageProducer = session.createProducer(destination);
		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// 6,创建消息
		for(int i = 0;i < 5; i++){
			TextMessage textMessage = session.createTextMessage();
			textMessage.setText("第"+i+"发送文本！！！-----lic");
			messageProducer.send(textMessage);
		}
		if(connection != null){
			connection.close();
		}
	}

}
