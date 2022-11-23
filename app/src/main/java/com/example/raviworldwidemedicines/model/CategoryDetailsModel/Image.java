package com.example.raviworldwidemedicines.model.CategoryDetailsModel;

import com.google.gson.annotations.SerializedName;

public class Image{

	@SerializedName("src")
	private String src;

	public Image(String src) {
		this.src = src;
	}

	public String getSrc() {
		return src;
	}

}