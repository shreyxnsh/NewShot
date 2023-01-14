package com.shreyxnsh.newsapi.Modals;

public class CategoryModal {

    // category variables
    private String category, categoryImageUrl;

    // constructor
    public CategoryModal(String category, String categoryImageUrl) {
        this.category = category;
        this.categoryImageUrl = categoryImageUrl;
    }

    // getter and setter methods for all the variables

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
