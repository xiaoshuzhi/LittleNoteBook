package com.Entity;

import java.util.List;

public class Note {
    private int  noteid;
    private String userid;
    private String abstractnote;
    private String username;
    private String source;
    private String directory;
    private String createtime;
    private String updatetime;
    private String islocked;
    private String isdele;
    private String directoryid;
    private float size;
    private String filename;
    private int labelnum;
    private List<Label> labels;
    private List<Img> imgs;

    public List<Img> getImgs() {
        return imgs;
    }

    public void setImgs(List<Img> imgs) {
        this.imgs = imgs;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAbstractnote() {
        return abstractnote;
    }

    public void setAbstractnote(String abstractnote) {
        this.abstractnote = abstractnote;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked;
    }

    public String getIsdele() {
        return isdele;
    }

    public void setIsdele(String isdele) {
        this.isdele = isdele;
    }

    public String getDirectoryid() {
        return directoryid;
    }

    public void setDirectoryid(String directoryid) {
        this.directoryid = directoryid;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLabelnum() {
        return labelnum;
    }

    public void setLabelnum(int labelnum) {
        this.labelnum = labelnum;
    }



    @Override
    public String toString() {
        return "Note{" +
                "noteid=" + noteid +
                ", userid='" + userid + '\'' +
                ", abstractnote='" + abstractnote + '\'' +
                ", username='" + username + '\'' +
                ", source='" + source + '\'' +
                ", directory='" + directory + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", islocked='" + islocked + '\'' +
                ", isdele='" + isdele + '\'' +
                ", directoryid='" + directoryid + '\'' +
                ", size=" + size +
                ", filename='" + filename + '\'' +
                ", labelnum=" + labelnum +
                ", labels=" + labels +
                ", imgs=" + imgs +
                '}';
    }
}
