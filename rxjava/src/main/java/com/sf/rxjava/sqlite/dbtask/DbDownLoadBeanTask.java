package com.sf.rxjava.sqlite.dbtask;

import android.content.Context;

import com.sf.rxjava.sqlite.dao.DownLoadBeanDao;
import com.sf.rxjava.sqlite.dao.imple.DownLoadImple;
import com.sf.rxjava.sqlite.dbtable.DownloadBean;

import java.util.List;

/**
 * DbDownLoadBeanTask.save(context,downloadBean):直接调用传入参数即可。相当于Java开发中放服务层
 * @author shufei.li on 2016/9/2.
 */
public class DbDownLoadBeanTask {

    public static List<DownloadBean> find(Context context,String url){
        DownLoadBeanDao downLoadBeanDao = new DownLoadImple(context);
        return downLoadBeanDao.findUrl(url);
    }

    public static int save(Context context,DownloadBean downloadBean) {
        DownLoadBeanDao downLoadBeanDao = new DownLoadImple(context);
        return downLoadBeanDao.addUrl(downloadBean);
    }

    public static List<DownloadBean> remove(Context context,String url){
        DownLoadBeanDao downLoadBeanDao = new DownLoadImple(context);
        return downLoadBeanDao.findUrl(url);
    }

    public static DownloadBean upDate(Context context,DownloadBean downloadBean){
        DownLoadBeanDao downLoadBeanDao = new DownLoadImple(context);

        return null;
    }
}
