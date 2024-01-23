package com.springbook.view.controller;

public class ViewResolver {
	
	private String prefix;
	private String suffix;
	
	public String getView(String viewName) {
		return prefix + viewName +suffix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}
