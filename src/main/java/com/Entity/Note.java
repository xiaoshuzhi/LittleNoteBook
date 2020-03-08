package com.Entity;

public class Note {
    private Integer noteid;

    private String userid;

    private Integer directoryId;

    private String abstractnote;

    private String createtime;

    private String updatetime;

    private String islocked;

    private String isdele;

    private String filename;

    private Float size;

    private String type;

    private String contentType;

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Integer directoryId) {
        this.directoryId = directoryId;
    }

    public String getAbstractnote() {
        return abstractnote;
    }

    public void setAbstractnote(String abstractnote) {
        this.abstractnote = abstractnote == null ? null : abstractnote.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked == null ? null : islocked.trim();
    }

    public String getIsdele() {
        return isdele;
    }

    public void setIsdele(String isdele) {
        this.isdele = isdele == null ? null : isdele.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }
}