package com.sf.rxjava.request;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorkManager implements NetStateListener {

    private static final String TAG = "NetWorkManager";

    private NetWorkState netWorkState;

    private static NetWorkManager instance;

    private NetStateListener outsideNetStateListener;
    private Context mContext;

    private NetWorkManager(Context context) {
        initNetWorkState(context);
    }

    public static void init(Context context) {

        if (instance == null) {
            instance = new NetWorkManager(context);
        }
    }

    public static NetWorkManager getInstance(Context context) {
        if (instance == null) {
            instance = new NetWorkManager(context);
        }
        return instance;
    }

    /**
     * 设置外部监听
     *
     * @param netStateListener
     */
    public void setOutsideNetStateListener(NetStateListener netStateListener) {
        outsideNetStateListener = netStateListener;
    }

    /**
     * 判断当前是否有网络链接
     *
     * @param context
     * @return
     */
    public void initNetWorkState(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        netWorkState = getNetWorkState();
        NetstateReceiver.registerNetStateListener(this);
    }

    private NetWorkState getNetWorkState() {
        NetWorkState state = new NetWorkState(NetWorkState.NET_UNKNOW);
        try {
            ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo activeInfo = connectivity.getActiveNetworkInfo();
                if (activeInfo != null && activeInfo.isConnected()) {
                    // 判断当前网络是否已经连接
                    if (activeInfo.getState() == NetworkInfo.State.CONNECTED) {
                        if (activeInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                            state.state = NetWorkState.NET_WIFI;
                        } else if (activeInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                            state.state = NetWorkState.NET_MOBILE;
                        } else if (activeInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
                            state.state = NetWorkState.TYPE_ETHERNET;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return state;
    }

    /**
     * 获取当前连接方式
     * <p/>
     * 1;//移动网络
     * 2;//wifi网络
     * 3;//无网络
     *
     * @return
     */
    public int getConnectType() {
        return netWorkState.state;
    }

    /**
     * 判断是否有网络连接
     *
     * @return
     */
    public boolean isConnect() {
        boolean isConnect = netWorkState.state != NetWorkState.NET_UNKNOW;
        if (!isConnect) {
            netWorkState = getNetWorkState();
            isConnect = netWorkState.state != NetWorkState.NET_UNKNOW;
        }
        return isConnect;
    }

    /**
     * 判断当前是否有网络链接
     *
     * @param context
     * @return
     */
    public static int getConnectType(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        int netWorkState = NetWorkState.NET_UNKNOW;
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo activeInfo = connectivity.getActiveNetworkInfo();
                if (activeInfo != null && activeInfo.isConnected()) {
                    // 判断当前网络是否已经连接
                    if (activeInfo.getState() == NetworkInfo.State.CONNECTED) {
                        if (activeInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                            netWorkState = NetWorkState.NET_WIFI;
                        }
                    } else if (activeInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                        netWorkState = NetWorkState.NET_MOBILE;
                    }
                }
            }
        } catch (Exception e) {
//            Log.v(TAG, "isConnect error " + e.toString());
        }
        return netWorkState;
    }

    @Override
    public void onConnect(int type) {
        netWorkState.state = type;
        if (outsideNetStateListener != null) {
            outsideNetStateListener.onConnect(type);
        }
    }

    @Override
    public void onDisConnect() {
        netWorkState.state = NetWorkState.NET_UNKNOW;
        if (outsideNetStateListener != null) {
            outsideNetStateListener.onDisConnect();
        }
    }

    /**
     * 释放对象
     */
    public static void release() {
        if (instance != null) {
            NetstateReceiver.unRegisterNetStateListener(instance);
            instance.outsideNetStateListener = null;
        }
        instance = null;
    }

}
