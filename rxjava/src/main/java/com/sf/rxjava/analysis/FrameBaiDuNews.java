package com.sf.rxjava.analysis;

import java.io.Serializable;
import java.util.List;

/**
 * @author shufei.li on 2016/8/26.
 */
public class FrameBaiDuNews implements Serializable{

    /**
     * 所有的页数
     */
    private int allPages;
    /**
     * 内容集合
     */
    private List<FrameContentListBean> contentlist;
    /**
     * 所有页码
     */
    private int allNum;
    /**
     * 最大请求内容结果为20条集合数据
     */
    private int maxResult;

    public void setContentlist(List<FrameContentListBean> contentlist) {
        this.contentlist = contentlist;
    }

    public List<FrameContentListBean> getContentlist() {
        return contentlist;
    }
}
