package com.example.raviworldwidemedicines.model;

public class DynamicRvModel {
    String itemname,services_Contents;

    int images;
    public DynamicRvModel(String itemname,int image, String services_Contents){
        this.itemname=itemname;
        this.images=image;
        this.services_Contents=services_Contents;
    }

    public String getItemname() {
        return itemname;
    }

    public int getImages() {
        return images;
    }


    public String getServices_Contents() {
        return services_Contents;
    }
}
