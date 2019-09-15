package com.Entity;

public class ImgErro {
    private int error;
    private String message;
    private String url;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        if(message!=null){
            return "{error:\"" + error + "\", message:\"" + message + "\"}";
        }else{
            return "{error:\"" + error + "\", url:\""+ url + "\"}";
        }

    }
}
