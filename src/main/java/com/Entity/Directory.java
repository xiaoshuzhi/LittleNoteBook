package com.Entity;

public class Directory {
    private String directoryid;
    private String userid;
    private String directory;
    private String isddele;
    private String isdlocked;
    private String defuatForder;

    public String getDefuatForder() {
        return defuatForder;
    }

    public void setDefuatForder(String defuatForder) {
        this.defuatForder = defuatForder;
    }

    public String getDirectoryid() {
        return directoryid;
    }

    public void setDirectoryid(String directoryid) {
        this.directoryid = directoryid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getIsddele() {
        return isddele;
    }

    public void setIsddele(String isddele) {
        this.isddele = isddele;
    }

    public String getIsdlocked() {
        return isdlocked;
    }

    public void setIsdlocked(String isdlocked) {
        this.isdlocked = isdlocked;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "directoryid='" + directoryid + '\'' +
                ", userid='" + userid + '\'' +
                ", directory='" + directory + '\'' +
                ", isddele='" + isddele + '\'' +
                ", isdlocked='" + isdlocked + '\'' +
                ", defuatForder='" + defuatForder + '\'' +
                '}';
    }
}
