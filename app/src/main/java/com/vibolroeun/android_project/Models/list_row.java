package com.vibolroeun.android_project.Models;

public class list_row {

    private String title;
    private int photo;
    private String description;
    private String price;
    private String account;

    public list_row(String title, int photo, String description, String price, String account) {
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.price = price;
        this.account = account;
    }

    public list_row() {


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String  getPrice() {
        return price;
    }

    public void setPrice(String  price) {
        this.price = price;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
