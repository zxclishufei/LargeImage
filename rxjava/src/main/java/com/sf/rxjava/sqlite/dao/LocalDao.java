package com.sf.rxjava.sqlite.dao;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.sf.rxjava.app.Application;
import com.sf.rxjava.sqlite.db.DatabaseHelper;

import java.sql.SQLException;

public class LocalDao {
	private Context context;
	public static DatabaseHelper dbHelper = null;
	public static ConnectionSource connectionSource = null;

	public void initDao() {
		this.context = Application.appContext;
		dbHelper = new DatabaseHelper(context);
		connectionSource = dbHelper.getConnectionSource();
	}

	public static DatabaseHelper getDbHelper(Context context) {
		if (dbHelper == null) {
			dbHelper = new DatabaseHelper(context);
		}
		return dbHelper;
	}

	public static ConnectionSource getConnectionSource(Context context) {
		if (connectionSource == null) {
			connectionSource = getDbHelper(context).getConnectionSource();
		}
		return connectionSource;
	}

	/**
	 * 初始化实例DAO
	 * 
	 * @param context
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public <T> Dao<T, Integer> getDao(Context context, Class<T> clazz) {
		if (dbHelper == null || connectionSource == null) {
			initDao();
		}
		Dao<T, Integer> dao = null;
		try {
			dao = DaoManager.createDao(connectionSource, clazz);
		} catch (SQLException e) {
			Log.e("SQLException", e.getMessage());
		}
		return dao;
	}

}
