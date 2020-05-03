package com.qiuhen.mq.mq_uitl;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQQueues {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	public void sendMSG(String destinationName,String message) {
//		String message = "这是第一条mq消息";
//		String destinationName = "test";
		System.out.println("发送消息++++=="+message);
		Destination destination = new ActiveMQQueue(destinationName);
		jmsMessagingTemplate.convertAndSend(destination,message);
	}
	
	@JmsListener(destination = "test")
	public void receiveMsg(String text) {
		
		System.out.println("消息为："+text);
	}
	
	
	
}
