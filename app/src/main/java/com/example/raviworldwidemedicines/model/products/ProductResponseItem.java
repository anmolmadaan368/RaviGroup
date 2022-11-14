package com.example.raviworldwidemedicines.model.products;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductResponseItem{

	@SerializedName("image")
	private List<Object> image;

	@SerializedName("name")
	private String name;

	@SerializedName("short_description")
	private String short_description;
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

	public String getShort_description() {
		return short_description;
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