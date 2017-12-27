package lzm.jiyun.com.xiongmaopindao.fragment.zbfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.zbadapter.Zb_DraAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.BaseDra;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class zb_DirectFragment extends BaseFragment<LivePresenter, LiveModel> implements LiveContract.View {


    private PullToRefreshRecyclerView dire_pulls;
    private List<BaseDra.VideoBean> videos = new ArrayList<>();
    private Zb_DraAdapter zb_draAdapter;

    public zb_DirectFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        dire_pulls = (PullToRefreshRecyclerView) view.findViewById(R.id.dire_pullrecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dire_pulls.setLayoutManager(linearLayoutManager);
        zb_draAdapter = new Zb_DraAdapter(videos);
        dire_pulls.setAdapter(zb_draAdapter);
    }

    @Override
    protected void initData() {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String url = arguments.getString("url");
            Log.e("数据1", url);
            mPresenter.presenter_Method(8, url);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zb__direct;
    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type) {
            case 8:
                BaseDra baseDra = gson.fromJson(string, BaseDra.class);
                List<BaseDra.VideoBean> video = baseDra.getVideo();
                videos.addAll(video);
                Log.e("数据2", video.toString());
                zb_draAdapter.notifyDataSetChanged();
                break;
        }
    }

    public static zb_DirectFragment newInstance(String url) {
        zb_DirectFragment fragment = new zb_DirectFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }
}
