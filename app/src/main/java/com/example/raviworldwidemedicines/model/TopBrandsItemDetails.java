package com.example.raviworldwidemedicines.model;

public class TopBrandsItemDetails {
    private String medicines_name,expairy_date,original_price,manufacturer_name;
    private int medicine_image;
    private float discount_rate;

    public TopBrandsItemDetails(String medicines_name, String expairy_date, String original_price,String manufacturers_name, int medicine_image,float discount_rate) {
        this.medicines_name = medicines_name;
        this.expairy_date = expairy_date;
        this.original_price = original_price;
        this.medicine_image = medicine_image;
        this.discount_rate = discount_rate;
        this.manufacturer_name=manufacturers_name;
    }

    public String getExpairy_date() {
        return expairy_date;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public int getMedicine_image() {
        return medicine_image;
    }

    public String getMedicines_name() {
        return medicines_name;
    }

    public float getDiscount_rate() {
        return discount_rate;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }
}
