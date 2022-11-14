package com.example.raviworldwidemedicines.model;

public class SingleProductDetailsModel {
    private String name,short_description;
    private Object medicine_image;
    private String Static_medicine_images;

    public SingleProductDetailsModel(String name, String short_description, Object imgs) {
        this.name = name;
        this.short_description = short_description;
        medicine_image = imgs;
    }

    public SingleProductDetailsModel(String name, String short_description,  String static_medicine_images) {
        this.name = name;
        this.short_description = short_description;
        this.Static_medicine_images = static_medicine_images;
    }

    public String getName() {
        return name;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getStatic_medicine_images() {
        return Static_medicine_images;
    }

    public Object getMedicine_image() {
        return medicine_image;
    }
}
