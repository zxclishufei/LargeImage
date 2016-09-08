package com.sf.rxjava.sqlite.dao.imple;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.sf.rxjava.sqlite.dao.DownLoadBeanDao;
import com.sf.rxjava.sqlite.dao.LocalDao;
import com.sf.rxjava.sqlite.dbtable.DownloadBean;

import java.sql.SQLException;
import java.util.List;

/**
 *  @author shufei.li on 2016/9/1.
 */
public class DownLoadImple  implements DownLoadBeanDao{

    Context mContext;
    LocalDao localDao = new LocalDao();
    Dao<DownloadBean,Integer> dao =localDao.getDao(mContext,DownloadBean.class);

    public  DownLoadImple(){
    }
    public DownLoadImple(Context context){
        this.mContext = context;
    }


    @Override
    public int addUrl(DownloadBean downloadBean) {
        try{
            return dao.create(downloadBean);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<DownloadBean> findUrl( String url) {
        try{
            QueryBuilder<DownloadBean, Integer> qb = dao.queryBuilder();
            qb.where().eq("programmeUrl", url);
            PreparedQuery<DownloadBean> preparedQuery = qb.prepare();
            return dao.query(preparedQuery);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeUrl( List<DownloadBean> downloadBeanList) {
        try{
            dao.delete(downloadBeanList);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void upDataUrl(DownloadBean downloadBean, int id) {
        try{
            dao.update(downloadBean);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
