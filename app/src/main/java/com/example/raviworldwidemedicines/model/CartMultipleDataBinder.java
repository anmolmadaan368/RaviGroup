package com.example.raviworldwidemedicines.model;

public class CartMultipleDataBinder {

    int product_image;
    String product_name;
    String salt_name;
    Object  api_product_image;
    String short_description;
    String chemical_amount;
    public CartMultipleDataBinder(int product_image,String product_name, String salt_name,String short_description,String chemical_amount){
        this.product_image=product_image;
        this.product_name=product_name;
        this.short_description=short_description;
        this.salt_name=salt_name;
        this.chemical_amount=chemical_amount;
    }

    public CartMultipleDataBinder(Object product_image,String product_name, String salt_name,String short_description,String chemical_amount){
        this.api_product_image=product_image;
        this.product_name=product_name;
        this.short_description=short_description;
    }

    public int getProduct_image() {
        return product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getSalt_name() {
        return salt_name;
    }

    public Object getApi_product_image() {
        return api_product_image;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getChemical_amount() {
        return chemical_amount;
    }
}
