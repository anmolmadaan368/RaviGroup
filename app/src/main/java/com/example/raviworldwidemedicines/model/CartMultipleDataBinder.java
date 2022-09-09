package com.example.raviworldwidemedicines.model;

public class CartMultipleDataBinder {

    int product_image;
    String product_name;
    String salt_name;
    String manufacturer_name;
    String chemical_amount;
    public CartMultipleDataBinder(int product_image,String product_name, String salt_name,String manufacturer_name,String chemical_amount){
        this.product_image=product_image;
        this.product_name=product_name;
        this.manufacturer_name=manufacturer_name;
        this.salt_name=salt_name;
        this.chemical_amount=chemical_amount;
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

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public String getChemical_amount() {
        return chemical_amount;
    }
}
