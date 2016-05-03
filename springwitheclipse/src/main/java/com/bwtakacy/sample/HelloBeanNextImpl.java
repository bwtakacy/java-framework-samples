package com.bwtakacy.sample;

public class HelloBeanNextImpl implements HelloBean {

	private String title;
	private String message;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("This is \"" + this.getTitle() + "\".");
		System.out.println("Message is \"" + this.getMessage() + "\"");
		System.out.println("-------------end---------------");
	}

}
