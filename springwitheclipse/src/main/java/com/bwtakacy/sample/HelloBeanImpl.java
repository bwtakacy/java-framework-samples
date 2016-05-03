package com.bwtakacy.sample;

public class HelloBeanImpl implements HelloBean {

	private String title;
	private String message;
	
	public HelloBeanImpl(String title, String message) {
		super();
		this.title = title;
		this.message = message;
	}
	
	public HelloBeanImpl() {
		super();
	}
	
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
		System.out.println("=============================");
		System.out.println(" <<" + this.getTitle() + ">>");
		System.out.println("-----------------------------");
		System.out.println(this.getMessage());
		System.out.println("=============================");
	}

}
