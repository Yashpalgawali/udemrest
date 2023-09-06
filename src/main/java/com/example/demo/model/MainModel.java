package com.example.demo.model;

public class MainModel {

	private String str;
	public MainModel(String str)
	{
		this.str=str;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		return "MainModel [str=" + str + "]";
	}
	
}
