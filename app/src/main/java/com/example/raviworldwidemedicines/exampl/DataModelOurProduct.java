package com.example.raviworldwidemedicines.exampl;

public class DataModelOurProduct{

    int item_image;
    String item_name;
    public DataModelOurProduct(int item_image,String item_desc){
        this.item_image=item_image;
        this.item_name=item_desc;
    }

    public int getItem_image() {
        return item_image;
    }

    public String getItem_name() {
        return item_name;
    }
}
