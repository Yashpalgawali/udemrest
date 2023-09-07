package com.example.demo.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MainModel;

@RestController
public class MainController {

	
	private MessageSource messageSource;

	public MainController(MessageSource msg)
	{
		messageSource = msg;
	}
	
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
	
	@GetMapping("/hello-world")
	public String helloInternational()
	{
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//return "hello world internationalized";
	}
}
