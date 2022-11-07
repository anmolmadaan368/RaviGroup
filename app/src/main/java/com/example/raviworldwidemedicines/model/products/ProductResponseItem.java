package com.example.raviworldwidemedicines.model.products;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductResponseItem{

	@SerializedName("image")
	private List<Object> image;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("categories")
	private ArrayList<CategoriesItem> categories;

	@SerializedName("slug")
	private String slug;

	public List<Object> getImage(){
		return image;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public ArrayList<CategoriesItem> getCategories(){
		return categories;
	}

	public String getSlug(){
		return slug;
	}
}