package lzm.jiyun.com.xiongmaopindao.fragment.zbfragment.bfragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidkun.PullToRefreshRecyclerView;
import com.google.gson.Gson;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.zbadapter.Zb_LiaoAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLiao;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZbLiao_Fragment extends BaseFragment<LivePresenter, LiveModel> implements LiveContract.View {


    private EditText zbliao_ed;
    private Button zbliao_but;
    private PullToRefreshRecyclerView zbliao_pullrecy;

    public ZbLiao_Fragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        zbliao_ed = (EditText) view.findViewById(R.id.zbliao_ed);
        zbliao_but = (Button) view.findViewById(R.id.zbliao_but);
        zbliao_pullrecy = (PullToRefreshRecyclerView) view.findViewById(R.id.zbliao_pullrecy);
        mPresenter.presenter_Method(0,"http://newcomment.cntv.cn/comment/list?prepage=20&app=ipandaApp&itemid=zhiboye_chat&nature=1&page=1");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zb_liao_;
    }

//    @Override
//    protected void LanJia() {
//
//    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type) {
            case 0:
                BaseLiao baseLiao = gson.fromJson(string, BaseLiao.class);
                List<BaseLiao.DataBean.ContentBean> content = baseLiao.getData().getContent();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                zbliao_pullrecy.setLayoutManager(linearLayoutManager);
                Zb_LiaoAdapter zb_liaoAdapter = new Zb_LiaoAdapter(content);
                zbliao_pullrecy.setAdapter(zb_liaoAdapter);
                break;
        }
    }
}
