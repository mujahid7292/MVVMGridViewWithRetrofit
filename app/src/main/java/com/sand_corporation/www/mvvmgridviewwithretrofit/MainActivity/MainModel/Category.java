package com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("ID")
    @Expose()
    public String id;

    @SerializedName("Title")
    @Expose()
    public String title;

    @SerializedName("Description")
    @Expose()
    public String description;

    @SerializedName("ImageUrl")
    @Expose()
    public String imageUrl;

    public Category() {

    }

    public Category(String id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
