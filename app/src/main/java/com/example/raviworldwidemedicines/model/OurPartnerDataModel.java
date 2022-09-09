package com.example.raviworldwidemedicines.model;

import android.widget.ImageView;
import android.widget.TextView;

public class OurPartnerDataModel {

    String partner_designation;
    int partners_image;
    String  partners_name;
     String partners_desc;
    public OurPartnerDataModel(int partner_image,String partners_name,String our_partners_designation, String our_partners_desc ){
        this.partner_designation=our_partners_designation;
        this.partners_image=partner_image;
        this.partners_name=partners_name;
        this.partners_desc=our_partners_desc;
    }

    public int getPartners_image() {
        return partners_image;
    }

    public String getPartners_name() {
        return partners_name;
    }

    public String getPartners_desc() {
        return partners_desc;
    }

    public String getPartner_designation() {
        return partner_designation;
    }
}
