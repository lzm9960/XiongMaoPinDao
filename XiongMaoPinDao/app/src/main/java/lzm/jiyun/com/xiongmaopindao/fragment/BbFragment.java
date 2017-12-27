package lzm.jiyun.com.xiongmaopindao.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.bbadapter.Bb_boAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.entiygun.BaseBob;
import lzm.jiyun.com.xiongmaopindao.entity.entiygun.BaseBobitem;
import lzm.jiyun.com.xiongmaopindao.fragment.bbfragment.BoBaoActivity;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BbFragment extends BaseFragment<LivePresenter, LiveModel> implements LiveContract.View {


    private PullToRefreshRecyclerView bb_pullrecy;
    private Bb_boAdapter bb_boAdapter;
    private List<BaseBobitem.ListBean> lists=new ArrayList<>();

    public BbFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        bb_pullrecy = (PullToRefreshRecyclerView) view.findViewById(R.id.bb_pullrecy);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        bb_pullrecy.setLayoutManager(linearLayoutManager);
        bb_boAdapter = new Bb_boAdapter(lists);
        bb_pullrecy.setAdapter(bb_boAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.presenter_Method(0,"http://www.ipanda.com/kehuduan/news/index.json");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bb;
    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type){
            case 0:
                BaseBob baseBob = gson.fromJson(string, BaseBob.class);
                BaseBob.DataBean data = baseBob.getData();
                initHear(data);
                String listurl = data.getListurl();
                mPresenter.presenter_Method(1,listurl);
                break;
            case 1:
                BaseBobitem baseBobitem = gson.fromJson(string, BaseBobitem.class);
                List<BaseBobitem.ListBean> list = baseBobitem.getList();
                lists.addAll(list);
                bb_boAdapter.notifyDataSetChanged();
                initDian();
                break;
        }

    }

    private void initDian() {
        bb_boAdapter.setOnClikeList(new BaseAdapter.OnClike() {
            @Override
            public void setOnClike(View view, int position) {
                String url = lists.get(position).getUrl();
                Intent intent = new Intent(getActivity(), BoBaoActivity.class);
                intent.putExtra("urls",url);
                getActivity().startActivity(intent);
            }
        });
    }

    private void initHear(BaseBob.DataBean data) {
        final View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.gg_header, null);
        ImageView gg_image=(ImageView)inflate.findViewById(R.id.gg_image);
        final List<BaseBob.DataBean.BigImgBean> bigImg = data.getBigImg();
        for (int i = 0; i <bigImg.size(); i++) {
            Glide.with(getActivity()).load(bigImg.get(i).getImage()).into(gg_image);
        }
        gg_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BoBaoActivity.class);
                intent.putExtra("url",bigImg.get(0).getUrl());
                getActivity().startActivity(intent);
            }
        });
        bb_pullrecy.addHeaderView(inflate);
    }


}
