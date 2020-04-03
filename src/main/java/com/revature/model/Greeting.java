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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeting other = (Greeting) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", content:" + content + "]";
	}

	
}
