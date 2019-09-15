package com.Entity;

public class Img {
    private String imgid;
    private String ingname;
    private String userid;
    private int noteid;
    private double imgsize;
    private String isdelete;

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public String getIngname() {
        return ingname;
    }

    public void setIngname(String ingname) {
        this.ingname = ingname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public double getImgsize() {
        return imgsize;
    }

    public void setImgsize(double imgsize) {
        this.imgsize = imgsize;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "Img{" +
                "imgid='" + imgid + '\'' +
                ", ingname='" + ingname + '\'' +
                ", userid='" + userid + '\'' +
                ", noteid=" + noteid +
                ", imgsize=" + imgsize +
                ", isdelete='" + isdelete + '\'' +
                '}';
    }
}
