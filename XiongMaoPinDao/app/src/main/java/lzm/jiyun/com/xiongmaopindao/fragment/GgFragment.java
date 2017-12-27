package lzm.jiyun.com.xiongmaopindao.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.ggadapter.GgAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.entiygun.BaseGun;
import lzm.jiyun.com.xiongmaopindao.fragment.ggBoFang.GgActivity;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GgFragment extends BaseFragment<LivePresenter,LiveModel> implements LiveContract.View{


    private PullToRefreshRecyclerView gg_recy;

    public GgFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        gg_recy = (PullToRefreshRecyclerView) view.findViewById(R.id.gg_recy);
        mPresenter.presenter_Method(0,"http://www.ipanda.com/kehuduan/video/index.json");
    }

    @Override
    protected void initData() {
        gg_recy.setPullRefreshEnabled(true);
        gg_recy.setLoadingMoreEnabled(true);
        gg_recy.displayLastRefreshTime(true);
        gg_recy.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.presenter_Method(0,"http://www.ipanda.com/kehuduan/video/index.json");
                gg_recy.setRefreshComplete();
            }

            @Override
            public void onLoadMore() {
                gg_recy.setLoadMoreComplete();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gg;
    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type){
            case 0:
                BaseGun baseGun = gson.fromJson(string, BaseGun.class);
                List<BaseGun.ListBean> list = baseGun.getList();
                initHeader(baseGun);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                gg_recy.setLayoutManager(linearLayoutManager);
                GgAdapter ggAdapter = new GgAdapter(list);
                gg_recy.setAdapter(ggAdapter);
                ggAdapter.setOnClikeList(new BaseAdapter.OnClike() {
                    @Override
                    public void setOnClike(View view, int position) {
                        Intent intent = new Intent(getContext(), GgActivity.class);
                        startActivity(intent);
                    }
                });
                break;
        }
    }

    private void initHeader(BaseGun baseGun) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.gg_header, null);
        ImageView gg_image=(ImageView)inflate.findViewById(R.id.gg_image);
        List<BaseGun.BigImgBean> bigImg = baseGun.getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            Glide.with(getActivity()).load(bigImg.get(i).getImage()).into(gg_image);
        }
        gg_recy.addHeaderView(inflate);
    }
}
