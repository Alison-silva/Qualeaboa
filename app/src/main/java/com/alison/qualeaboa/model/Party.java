package com.alison.qualeaboa.model;

import com.google.gson.annotations.SerializedName;

public class Party {

    @SerializedName("id") private int id;
    @SerializedName("local") private String local;
    @SerializedName("timer") private String timer;
    @SerializedName("price") private String price;
    @SerializedName("description") private String description;
    @SerializedName("name") private String name;
    @SerializedName("party") private String party;
    @SerializedName("image") private String image;
    @SerializedName("day") private String day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
