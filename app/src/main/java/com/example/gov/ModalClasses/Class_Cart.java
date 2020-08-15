package com.example.gov.ModalClasses;

public class Class_Cart {
    private String title,desc,price,quantity;
    private String iwl;

    public Class_Cart(String title, String desc, String price, String quantity, String iwl) {
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
        this.iwl = iwl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getIwl() {
        return iwl;
    }

    public void setIwl(String iwl) {
        this.iwl = iwl;
    }
}
