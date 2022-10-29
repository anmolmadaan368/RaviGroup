package com.example.raviworldwidemedicines.model.products;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductsModel{

	@SerializedName("ProductsModel")
	private List<ProductsModelItem> productsModel;

	public List<ProductsModelItem> getProductsModel(){
		return productsModel;
	}
}