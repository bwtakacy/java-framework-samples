package com.bwtakacy.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MySpringBean {
	private List<MyData> list = new ArrayList<MyData>();
	
	public MySpringBean() {
		list.add(new MyData("bwtakacy", "bwtakacy@hoge.com", 123));
		list.add(new MyData("youko", "youko@hoge.com", 456));
		list.add(new MyData("akifumi", "aki@hoge.com", 789));
	}
	
	public void addData(MyData data) {
		list.add(data);
	}
	
	public MyData get(int num) {
		return list.get(num);
	}
	
	public int count() {
		return list.size();
	}
}

class MyData {
	private String name;
	private String mail;
	private int age;
	
	public MyData(String name, String mail, int age) {
		this.name = name;
		this.mail = mail;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "MyData [name=" + name + ", mail=" + mail +
				", age=" + age + "]";
	}
}
