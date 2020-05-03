package com.qiuhen.mq.mq_uitl;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQTopices {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	
	public void sendMsg(String msgName, String message) {
		
		Destination destination = new ActiveMQTopic(msgName);
		System.out.println("发布topic消息"+message);
		jmsMessagingTemplate.convertAndSend(destination,message);
		
	}
	
	@JmsListener(destination = "test",containerFactory = "myJmsContainerFactory")
	public void consumers(String text) {
		System.out.println("订阅的消息内容是:"+text);
	}
	
	@Bean
	JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
		SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setPubSubDomain(true);
		return factory;
	}
	
	
	
	
	
	
	
	
	
	

}
