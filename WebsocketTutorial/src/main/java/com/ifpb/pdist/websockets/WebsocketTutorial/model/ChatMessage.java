package com.ifpb.pdist.websockets.WebsocketTutorial.model;


public class ChatMessage {
	

	private MessageType type;
	

	private String content;
	

	private String sender;
	

	private String time;


	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ChatMessage() {}
	
	public ChatMessage(MessageType type, String sender) {
		this.type = type;
		this.sender = sender;
	}

}
