package com.qiuhen.mq.domain;

public class Message {
	private String msgName;
	private String message;
	
	public Message() {};
	
	public Message(String msgName, String message) {
		super();
		this.msgName = msgName;
		this.message = message;
	}
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [msgName=" + msgName + ", message=" + message + "]";
	}
	
}
