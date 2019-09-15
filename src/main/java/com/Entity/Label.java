package com.Entity;

public class Label {
    private int labelid;
    private String labelname;
    private String labeldele;
    private String userid;

    public int getLabelid() {
        return labelid;
    }

    public void setLabelid(int labelid) {
        this.labelid = labelid;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getLabeldele() {
        return labeldele;
    }

    public void setLabeldele(String labeldele) {
        this.labeldele = labeldele;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "{" +
                "labelid=" + labelid +
                ", labelname='" + labelname + '\'' +
                ", labeldele='" + labeldele + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
