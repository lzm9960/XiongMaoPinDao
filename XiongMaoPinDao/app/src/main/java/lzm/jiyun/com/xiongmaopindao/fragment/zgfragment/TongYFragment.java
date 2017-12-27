package lzm.jiyun.com.xiongmaopindao.fragment.zgfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.google.gson.Gson;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.zgadapetr.RecyTongAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.entityzg.BaseZgTong;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongYFragment extends BaseFragment<LivePresenter,LiveModel> implements LiveContract.View{


    private PullToRefreshRecyclerView zg_tong;

    public TongYFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        zg_tong = (PullToRefreshRecyclerView) view.findViewById(R.id.zg_tong);
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String url = arguments.getString("url");
        mPresenter.presenter_Method(0,url);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tong_y;
    }
    public static TongYFragment newInstance(String s) {

        Bundle args = new Bundle();
        args.putString("url",s);
        TongYFragment fragment = new TongYFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type){
            case 0:
                BaseZgTong baseZgTong = gson.fromJson(string, BaseZgTong.class);
                List<BaseZgTong.LiveBean> live = baseZgTong.getLive();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                zg_tong.setLayoutManager(linearLayoutManager);
                RecyTongAdapter recyTongAdapter = new RecyTongAdapter(live);
                zg_tong.setAdapter(recyTongAdapter);
                break;
        }
    }
}
