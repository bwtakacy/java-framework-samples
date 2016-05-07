package com.bwtakacy.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	@Autowired
	MyDataEntityRepository repo;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(@ModelAttribute("message")String msg,
			Model model) {
		model.addAttribute("title", "Hello Page");
		model.addAttribute("message", "MyDataEntity List.");
		List<MyDataEntity> data = repo.findAll();
		model.addAttribute("data", data);
		return "hello";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String form(@RequestParam("find") String find,
			Model model) {
		model.addAttribute("title", "Hello Page");
		model.addAttribute("value", find);
		model.addAttribute("message", "MyDataEntity List.");
		List<MyDataEntity> data = repo.findByName(find);
		model.addAttribute("data", data);
		return "hello";
	}

}
