package com.myhome.chat;

public class ChatDTO {

	private int seqUserChat;
	private int seqHost;
	private int seqTheOther;
	private String content;
	private String writetime;
	
	public int getSeqUserChat() {
		return seqUserChat;
	}
	public void setSeqUserChat(int seqUserChat) {
		this.seqUserChat = seqUserChat;
	}
	public int getSeqHost() {
		return seqHost;
	}
	public void setSeqHost(int seqHost) {
		this.seqHost = seqHost;
	}
	public int getSeqTheOther() {
		return seqTheOther;
	}
	public void setSeqTheOther(int seqTheOther) {
		this.seqTheOther = seqTheOther;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	
	
}
