package com.example.raviworldwidemedicines.model.AllProductsByCategory;

import java.util.List;

import com.example.raviworldwidemedicines.model.CategoryDetailsModel.Image;
import com.google.gson.annotations.SerializedName;

public class GetAllProductOfCategories {

	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("image")
	private List<Object> image;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	public String getShortDescription(){
		return shortDescription;
	}

	public List<Object> getImage(){
		return image;
	}

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

}