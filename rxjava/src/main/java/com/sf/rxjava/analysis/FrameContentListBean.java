package com.sf.rxjava.analysis;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author shufei.li on 2016/8/26.
 */
public class FrameContentListBean implements Serializable{
    /**
     * 点击标题进入的URL
     */
    private List<Object> allList;
    /**
     * 更新时间
     */
    private String pubDate ;
    /**
     * 一级数据标题
     */
    private String title;
    /**
     * 来源名称
     */
    private String channelName;
    /**
     *
     */
    private List<FrameImageUrl> imageurls;
    /**
     * 简单描述
     */
    private String desc;
    /**
     * 来源
     */
    private String source;
    /**
     * 来源Id
     */
    private String channelId;
    /**
     * 图片连接link
     */
    private String link;

    public List<Object> getAllList() {
        return allList;
    }

    public void setAllList(List<Object> allList) {
        this.allList = allList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<FrameImageUrl> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<FrameImageUrl> imageurls) {
        this.imageurls = imageurls;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
