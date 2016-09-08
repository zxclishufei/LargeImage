package com.sf.rxjava.analysis;

import java.io.Serializable;

/**
 *@author shufei.li on 2016/8/26.
 */
public class FrameImageUrl implements Serializable{
    private String url;
    private int height;
    private int width;
    private String fileUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

}
