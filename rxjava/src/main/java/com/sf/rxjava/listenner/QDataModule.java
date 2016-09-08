package com.sf.rxjava.listenner;

import java.util.ArrayList;
/**
 * 通过一个自定义监听接口实现Android两个任意类之间接收参数并且做出响应
 * @author shufei.li on 2016/8/23
 */
public class QDataModule {
    private static QDataModule instance = new QDataModule();
    public static QDataModule getInstance() {
        return instance;
    }
    private ArrayList<OnVideoChangeListener> videoChangeListenerList = new ArrayList<OnVideoChangeListener>();
    public void notifyVideoChangeListener(boolean isCarousel, int index) {
        for (OnVideoChangeListener listener : videoChangeListenerList) {
            listener.onChanged(isCarousel, index);
        }
    }
    public void addVideoListener(OnVideoChangeListener listener) {
        videoChangeListenerList.add(listener);
    }
    public void removeVideoListener(OnVideoChangeListener listener) {
        videoChangeListenerList.remove(listener);
    }
    public interface OnVideoChangeListener {
        public void onChanged(boolean isCarousel, int index);
    }
    // QDataModule.getInstance().notifyVideoChangeListener(true,mVideoIndex);//发出通知的类。并且把数据传送过去
    // QDataModule.getInstance().addVideoListener(this);//接收通知的类注册监听
    //implements QDataModule.OnVideoChangeListener //接收通知的类实现监听，回调方法接收参数，做出响应
    // QDataModule.getInstance().removeVideoListener(this);//接收通知的类等待响应结束注册监听
}