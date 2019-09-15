package com.Entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


public class NoteUser {
    private String userid;
    private String username;
    private String password;
    private int gender;
    private String address;
    private String logo;
    private int used;
    private int total;
    private int type;
    private String  readlock;
    private String datalocation;
    private String email;
    private String img;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getUse() {
        return used;
    }

    public void setUse(int use) {
        this.used = use;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public String getReadlock() {
        return readlock;
    }

    public void setReadlock(String readlock) {
        this.readlock = readlock;
    }

    public String getDatalocation() {
        return datalocation;
    }

    public void setDatalocation(String datalocation) {
        this.datalocation = datalocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", logo='" + logo + '\'' +
                ", used=" + used +
                ", total=" + total +
                ", type=" + type +
                ", readlock='" + readlock + '\'' +
                ", datalocation='" + datalocation + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
