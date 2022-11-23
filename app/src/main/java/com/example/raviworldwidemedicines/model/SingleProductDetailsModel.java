package com.example.raviworldwidemedicines.model;

import com.example.raviworldwidemedicines.model.CategoryDetailsModel.Image;

public class SingleProductDetailsModel {
    private String name,short_description;
    private Image medicine_image;

    public SingleProductDetailsModel(String name, String short_description,  Image imgs) {
        this.name = name;
        this.short_description = short_description;
        medicine_image = imgs;
    }
    public SingleProductDetailsModel(String name, String short_description) {
        this.name = name;
        this.short_description = short_description;
    }

    public String getName() {
        return name;
    }

    public String getShort_description() {
        return short_description;
    }

    public Image getMedicine_image() {
        return medicine_image;
    }
}
