package com.sf.rxjava.request;

import java.util.HashSet;
import java.util.Set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class NetstateReceiver extends BroadcastReceiver {

    private static final String TAG = "NetstateReceiver";
    public static Set<NetStateListener> listeners = new HashSet<NetStateListener>();

    @Override
    public void onReceive(Context context, Intent intent) {
        int connectType = NetWorkManager.getConnectType(context);
        Log.e(TAG, "connectType = " + connectType);
        if (listeners != null && listeners.size() > 0) {
            for (NetStateListener netStateListener : listeners) {
                if (connectType != NetWorkState.NET_UNKNOW) {
                    netStateListener.onConnect(connectType);
                } else {
                    netStateListener.onDisConnect();
                }
            }
        }
    }

    /**
     * 注册网络监听广播
     *
     * @param netStateListener
     */
    public static void registerNetStateListener(NetStateListener netStateListener) {
        listeners.add(netStateListener);
    }

    /**
     * 取消网络监听广播
     *
     * @param netStateListener
     */
    public static void unRegisterNetStateListener(NetStateListener netStateListener) {
        listeners.remove(netStateListener);
        Log.e(TAG, "unRegisterNetStateListener listeners count =  " + listeners.size());
    }

    public static void clean() {
        listeners.clear();
    }

}
