package com.example.raviworldwidemedicines.model.products;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductResponse{

	@SerializedName("productResponse")
	private List<ProductResponseItem> productResponse;

	public List<ProductResponseItem> getProductResponse(){
		return productResponse;
	}
}