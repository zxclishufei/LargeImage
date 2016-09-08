package com.sf.rxjava.sqlite.dao;

import com.sf.rxjava.sqlite.dbtable.DownloadBean;

import java.util.List;

/**
 * @author shufei.li on 2016/9/1.
 */
public interface DownLoadBeanDao {
    public int addUrl(DownloadBean downloadBean);
    public List<DownloadBean> findUrl(String url);
    public void removeUrl( List<DownloadBean> downloadBean);
    public void upDataUrl(DownloadBean downloadBean,int id);
}
