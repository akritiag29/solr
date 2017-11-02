package com.search.web.model;



public class Document {

	private String id;
	private String features;
	private String name;
	
	public Document (String id, String name, String features) {
		this.id = id;
		this.features = features;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public String getFeatures() {
		return features;
	}
	
	public String getName() {
		return name;
	}
	
}
