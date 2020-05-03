package com.qiuhen.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qiuhen.mq.domain.Message;
import com.qiuhen.mq.mq_uitl.ActiveMQQueues;
import com.qiuhen.mq.mq_uitl.ActiveMQTopices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "mq消息接口")
@RestController
public class MsgControl {
	
	@Autowired
	private ActiveMQQueues activeMQProducter;
	
	@Autowired
	private ActiveMQTopices activeMQTopices;
	
	@PostMapping("/sendQueues")
	@ApiOperation(value="mq发送队列消息接口", notes="测试mq发送消息接口")
	public String postQueuesMsg(@RequestBody Message msg) {
		
		System.out.println(msg.getMsgName());
		activeMQProducter.sendMSG(msg.getMsgName(),msg.getMessage());
		
		return "成功";
	}
	
	@PostMapping("/sendTopic")
	@ApiOperation(value="mq发送主题消息接口", notes="测试mq发送消息接口")
	public String postTopicMsg(@RequestBody Message msg) {
		
		
		activeMQTopices.sendMsg(msg.getMsgName(), msg.getMessage());
		
		return "成功";
	}
	
	

}
