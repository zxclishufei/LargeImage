package com.sf.rxjava.request;

public interface NetStateListener {
	/**
	 * 网络已连接
	 */
	public void onConnect(int type);
	
	/**
	 * 没有网络
	 */
	public void onDisConnect();
	
	
}
