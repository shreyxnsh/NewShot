package com.shreyxnsh.newsapi.Modals;

import java.util.ArrayList;

public class NewsModal {

    // after checking the api on postman, these are the variables required
    private int totalResults;
    private String status;
    // Article information is being stored in an array list
    private ArrayList<Articles> articles;

    // constructor
    public NewsModal(int totalResults, String status, ArrayList<Articles> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;
    }

    // getter and setter methods for all the variables

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }
}
