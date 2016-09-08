package com.sf.rxjava.request;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by 8 on 2016/8/25.
 */
public class NetWorkState {
    public static final int NET_MOBILE = 1;//移动网络
    public static final int NET_WIFI = 2;//wifi网络
    public static final int NET_UNKNOW = 3;//没有网络
    public static final int TYPE_ETHERNET = 4;//有线网络

    public int state = NET_UNKNOW;

    public NetWorkState(int initNetWorkState){
        state = initNetWorkState;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }
}
