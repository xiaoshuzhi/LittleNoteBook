package com.Entity;

public class Directory {
    private Integer id;

    private String userid;

    private String directoryName;

    private String isddele;

    private String isdlocked;

    private String defuatforder;

    private String createTime;

    private Integer fileNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName == null ? null : directoryName.trim();
    }

    public String getIsddele() {
        return isddele;
    }

    public void setIsddele(String isddele) {
        this.isddele = isddele == null ? null : isddele.trim();
    }

    public String getIsdlocked() {
        return isdlocked;
    }

    public void setIsdlocked(String isdlocked) {
        this.isdlocked = isdlocked == null ? null : isdlocked.trim();
    }

    public String getDefuatforder() {
        return defuatforder;
    }

    public void setDefuatforder(String defuatforder) {
        this.defuatforder = defuatforder == null ? null : defuatforder.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getFileNum() {
        return fileNum;
    }

    public void setFileNum(Integer fileNum) {
        this.fileNum = fileNum;
    }
}