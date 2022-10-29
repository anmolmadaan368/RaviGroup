package com.example.raviworldwidemedicines.model.products;

import com.example.raviworldwidemedicines.model.CategoryDetailsModel.Image;
import com.google.gson.annotations.SerializedName;

public class ProductsModelItem{

	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("image")
	private Image image;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public String getShortDescription(){
		return shortDescription;
	}

	public Image getImage(){
		return image;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}