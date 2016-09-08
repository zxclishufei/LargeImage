package com.sf.rxjava.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sf.rxjava.sqlite.dbtable.DownloadBean;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME = "heartTouch_db";
    public final static int DATABASE_VERSION = 1;// 版本号
    private Context context;

    /**
     * 构造函数方法，执行创库、更新文件等操作。
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * 程序第一次启动时，执行该方法。
     */
    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
        upGradeInit(sqliteDatabase, connectionSource);
    }

    /**
     * 数据库版本有更新时，执行该方法。
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
    }

    /**
     * 初始化创建数据库表
     *
     * @param sqliteDatabase
     * @param connectionSource
     */
    public void upGradeInit(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, DownloadBean.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to create databases", e);
        }
    }
}

