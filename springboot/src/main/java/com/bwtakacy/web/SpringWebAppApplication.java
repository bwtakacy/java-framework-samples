package com.bwtakacy.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebAppApplication {
	@Autowired
	MyDataEntityRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebAppApplication.class, args);
	}
	
	@PostConstruct
	public void initialData() {
		repo.save(new MyDataEntity("bwtakacy", "bwtakacy@hoge.com"));
		repo.save(new MyDataEntity("youko", "youko@hoge.com"));
		repo.save(new MyDataEntity("akifumi", "aki@hoge.com"));
		repo.flush();
	}
}
