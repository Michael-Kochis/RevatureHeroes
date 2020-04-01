package com.revature.model;

public class Greeting {

	private long id;
	private String content;

	public Greeting(long id, String content) {
		super();
		this.setId(id);
		this.setContent(content);
	}

	public long getId() {
		return id;
	}
	
	public void setId(long nid) {
		this.id = nid;
	}
	

	public String getContent() {
		return content;
	}
	
	public void setContent(String s) {
		this.content = s;
	}

	
}
