package com.Entity;

import java.util.List;

public class JsonString {
    private String message;
    private List<Note> lists;
    private String statuid;
    private String url;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Note> getLists() {
        return lists;
    }

    public void setLists(List<Note> lists) {
        this.lists = lists;
    }

    public String getStatuid() {
        return statuid;
    }

    public void setStatuid(String statuid) {
        this.statuid = statuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" +
                "message='" + message + '\'' +
                ", lists=" + lists +
                ", statuid='" + statuid + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
