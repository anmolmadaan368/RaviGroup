package com.example.raviworldwidemedicines.model.AllProductsByCategory;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetAllProductOfCategories {

	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("image")
	private List<ImageItem> image;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	public String getShortDescription(){
		return shortDescription;
	}

	public List<ImageItem> getImage(){
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