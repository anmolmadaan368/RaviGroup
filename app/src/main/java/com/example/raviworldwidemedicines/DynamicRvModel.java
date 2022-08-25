package com.example.raviworldwidemedicines;

public class DynamicRvModel {
    String itemname;

    int images;
    public DynamicRvModel(String itemname,int image){
        this.itemname=itemname;
        this.images=image;
    }

    public String getItemname() {
        return itemname;
    }

    public int getImages() {
        return images;
    }
}
