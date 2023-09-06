package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MainModel;

@RestController
public class MainController {

	@GetMapping("/fir")
	public String index()
	{
		return "First example";
	}
	
	@GetMapping("firbean")
	public MainModel getHelloBean()
	{
		return new MainModel("Hello Bean returned");
	}
	
	@GetMapping("firbean/{name}")
	public MainModel getPathVars(@PathVariable("name") String name)
	{
		return new MainModel("Hello "+name);
	}
}
