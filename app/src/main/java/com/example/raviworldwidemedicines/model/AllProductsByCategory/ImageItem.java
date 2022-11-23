package com.example.raviworldwidemedicines.model.AllProductsByCategory;

import com.google.gson.annotations.SerializedName;

public class ImageItem{

	@SerializedName("src")
	private String src;

	@SerializedName("name")
	private String name;
	@SerializedName("id")
	private int id;

	public String getSrc(){
		return src;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}