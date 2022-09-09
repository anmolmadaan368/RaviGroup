package com.example.raviworldwidemedicines.model;

public class BlogMultipleDataBinderObject {

    String heading_data;
    int blog_imag;
    String posting_date;
    String desc;

    public BlogMultipleDataBinderObject(String heading_data,int blog_imae,String posting_date,String desc){
        this.heading_data=heading_data;
        this.blog_imag=blog_imae;
        this.posting_date=posting_date;
        this.desc=desc;
    }

    public String getHeading_data() {
        return heading_data;
    }

    public int getBlog_imag() {
        return blog_imag;
    }

    public String getPosting_date() {
        return posting_date;
    }

    public String getDesc() {
        return desc;
    }
}
