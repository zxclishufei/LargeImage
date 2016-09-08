package com.canyinghao.canrefreshdemo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.canyinghao.canrefresh.CanRefreshLayout;
import com.sf.rxjava.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LinearLayoutFragment extends Fragment implements CanRefreshLayout.OnRefreshListener,CanRefreshLayout.OnLoadMoreListener {

    @Bind(R.id.refresh)
    CanRefreshLayout canRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_linear, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        ButterKnife.bind(this,v);
        canRefreshLayout.setOnRefreshListener(this);
        canRefreshLayout.setOnLoadMoreListener(this);
    }

    @Override
    public void onLoadMore() {

        canRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                canRefreshLayout.refreshComplete();
            }
        },2000);
    }

    @Override
    public void onRefresh() {
        canRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
              canRefreshLayout.loadMoreComplete();
            }
        },2000);
    }
}
