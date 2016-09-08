package com.sf.rxjava.download;

import android.content.Context;

import com.sf.rxjava.sqlite.dbtable.DownloadBean;
import com.sf.rxjava.sqlite.dbtask.DbDownLoadBeanTask;

import java.util.List;

/**
 * @author shufei.li on 2016/9/1.
 */
public class DownLoadManager {
    /**
     * 添加url加载获取本地保存Url
     * @return result
     */
    public  String GetLoadFileUrl(Context context,String url,DownloadBean downloadBean){
        List<DownloadBean> downloadList =  DbDownLoadBeanTask.find(context, url);
        if(downloadList != null && downloadList.size() > 1){
            //remove
            DbDownLoadBeanTask.remove(context, url);
            //add
            DbDownLoadBeanTask.save(context, downloadBean);
        }else if(downloadList.size() == 0){
            //add
            DbDownLoadBeanTask.save(context, downloadBean);
        }

        return "";
    }
}
