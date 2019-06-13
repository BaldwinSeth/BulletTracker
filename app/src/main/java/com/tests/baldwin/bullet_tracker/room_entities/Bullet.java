package com.tests.baldwin.bullet_tracker.room_entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

import com.tests.baldwin.bullet_tracker.helpers.TagFormatter;

import java.util.Date;

@Entity
public class Bullet {

    public Bullet(int id, Category category, String description, String[] tags, Date date, String details) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.tags = tags;
        this.date = date;
        this.details = details;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    //visible to main page
    @ColumnInfo(name = "category")
    private Category category;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "tags")
    private String[] tags;
    @ColumnInfo(name = "date")
    private Date date;
    @ColumnInfo(name = "details")
    private String details;

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getTags() {
        return TagFormatter.TagsToString(tags);
    }

    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(String tags) {
        this.tags = TagFormatter.StringToTags(tags);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public enum Category{
        Work,Leadership,Volunteer,misc
    }
}
