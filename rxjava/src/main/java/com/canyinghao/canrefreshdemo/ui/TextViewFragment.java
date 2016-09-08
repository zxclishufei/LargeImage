package com.canyinghao.canrefreshdemo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.canyinghao.canrefresh.CanRefreshLayout;
import com.sf.rxjava.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TextViewFragment extends Fragment implements CanRefreshLayout.OnRefreshListener, CanRefreshLayout.OnLoadMoreListener {

    @Bind(R.id.refresh)
    CanRefreshLayout refreshLayout;
    @Bind(R.id.can_content_view)
    TextView tvContent;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text_view, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        ButterKnife.bind(this,v);
        tvContent = (TextView)v.findViewById(R.id.can_content_view);
        tvContent.setMovementMethod(LinkMovementMethod.getInstance());
        tvContent.setText(Html.fromHtml(getResources().getString(R.string.app_about)));
        refreshLayout.setOnLoadMoreListener(this);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onLoadMore() {
            refreshLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                  refreshLayout.loadMoreComplete();
                }
            },2000);
    }

    @Override
    public void onRefresh() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.refreshComplete();
            }
        },2000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}

