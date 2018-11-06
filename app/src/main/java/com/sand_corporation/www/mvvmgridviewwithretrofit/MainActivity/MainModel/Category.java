package com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainModel;

public class Category {

    public String id;
    public String title;
    public String description;
    public String imageUrl;

    public Category() {

    }

    public Category(String id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
