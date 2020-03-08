package com.Entity;

public class UserConfig {
    private Integer id;

    private Integer maxMemery;

    private Integer maxDir;

    private Integer maxFile;

    private Integer maxDefFile;

    private Integer maxImg;

    private String exportFile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxMemery() {
        return maxMemery;
    }

    public void setMaxMemery(Integer maxMemery) {
        this.maxMemery = maxMemery;
    }

    public Integer getMaxDir() {
        return maxDir;
    }

    public void setMaxDir(Integer maxDir) {
        this.maxDir = maxDir;
    }

    public Integer getMaxFile() {
        return maxFile;
    }

    public void setMaxFile(Integer maxFile) {
        this.maxFile = maxFile;
    }

    public Integer getMaxDefFile() {
        return maxDefFile;
    }

    public void setMaxDefFile(Integer maxDefFile) {
        this.maxDefFile = maxDefFile;
    }

    public Integer getMaxImg() {
        return maxImg;
    }

    public void setMaxImg(Integer maxImg) {
        this.maxImg = maxImg;
    }

    public String getExportFile() {
        return exportFile;
    }

    public void setExportFile(String exportFile) {
        this.exportFile = exportFile == null ? null : exportFile.trim();
    }
}