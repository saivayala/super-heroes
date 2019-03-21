package com.sai8.superheros.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Favoriteheros")
public class HeroModel {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "hero_id")
    private String id;
    @ColumnInfo(name = "hero_name")
    private String name;
    @ColumnInfo(name = "hero_intteligence")
    private String intelligence;
    @ColumnInfo(name = "hero_strength")
    private String strength;
    @ColumnInfo(name = "hero_speed")
    private String speed;
    @ColumnInfo(name = "hero_durability")
    private String durability;
    @ColumnInfo(name = "hero_power")
    private String power;
    @ColumnInfo(name = "hero_combat")
    private String combat;
    @ColumnInfo(name = "hero_realname")
    private String realname;
    @ColumnInfo(name = "hero_place")
    private String place;
    @ColumnInfo(name = "hero_publisher")
    private String publisher;
    @ColumnInfo(name = "hero_height")
    private String height;
    @ColumnInfo(name = "hero_weight")
    private String weight;
    @ColumnInfo(name = "hero_image")
    private String imageurl;
    @ColumnInfo(name = "hero_firstappeare")
    private String firstappear;


    public HeroModel(@NonNull String id, String name, String intelligence, String strength, String speed, String durability, String power, String combat, String realname, String place, String publisher, String height, String weight, String imageurl, String firstappear) {
        this.id = id;
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
        this.realname = realname;
        this.place = place;
        this.publisher = publisher;
        this.height = height;
        this.weight = weight;
        this.imageurl = imageurl;
        this.firstappear = firstappear;
    }

    public HeroModel() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setFirstappear(String firstappear) {
        this.firstappear = firstappear;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDurability() {
        return durability;
    }

    public String getPower() {
        return power;
    }

    public String getCombat() {
        return combat;
    }

    public String getRealname() {
        return realname;
    }

    public String getPlace() {
        return place;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getFirstappear() {
        return firstappear;
    }
}
