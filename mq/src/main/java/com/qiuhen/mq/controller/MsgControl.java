package com.qiuhen.mq.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "mq消息接口")
@RestController
public class MsgControl {
	
	
	@RequestMapping("/send")
	@ApiOperation(value="mq消息接口", notes="测试mq消息接口")
	public String postMsg() {
		
		
		
		return "成功";
	}
	
	

}
