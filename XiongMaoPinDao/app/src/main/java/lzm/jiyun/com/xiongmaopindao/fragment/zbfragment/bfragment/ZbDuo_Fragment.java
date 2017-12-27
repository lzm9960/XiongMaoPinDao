package lzm.jiyun.com.xiongmaopindao.fragment.zbfragment.bfragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.zbadapter.Zb_DuoAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLive;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLive_Duo;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLivelive;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZbDuo_Fragment extends BaseFragment<LivePresenter, LiveModel> implements LiveContract.View{


    private RecyclerView zbduo_recy;

    public ZbDuo_Fragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        zbduo_recy = (RecyclerView) view.findViewById(R.id.zbduo_recy);
        mPresenter.presenter_Method(0,"http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zb_duo_;
    }

//    @Override
//    protected void LanJia() {
//
//    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type){
            case 0:
                BaseLive baseLive = gson.fromJson(string, BaseLive.class);
                List<BaseLive.TablistBean> tablist = baseLive.getTablist();
                String url = tablist.get(0).getUrl();
                mPresenter.presenter_Method(1, url);
                break;
            case 1:
                BaseLivelive baseLivelive = gson.fromJson(string, BaseLivelive.class);
                BaseLivelive.BookmarkBean bookmark = baseLivelive.getBookmark();
                List<BaseLivelive.BookmarkBean.MultipleBean> multiple = bookmark.getMultiple();
//                List<BaseLivelive.BookmarkBean.WatchTalkBean> watchTalk = bookmark.getWatchTalk();
                String urls = multiple.get(0).getUrl();
//                String urlss = watchTalk.get(0).getUrl();
                mPresenter.presenter_Method(2,urls);
                break;
            case 2:
                BaseLive_Duo baseLive_duo = gson.fromJson(string, BaseLive_Duo.class);
                List<BaseLive_Duo.ListBean> list = baseLive_duo.getList();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
                zbduo_recy.setLayoutManager(gridLayoutManager);
                Zb_DuoAdapter zb_duoAdapter = new Zb_DuoAdapter(list);
                zbduo_recy.setAdapter(zb_duoAdapter);
                break;
        }
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser == true) {
//            mPresenter.presenter_Method(0,"http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
//        }
//    }
}
