package lzm.jiyun.com.xiongmaopindao.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.FragmentTabAdapter;
import lzm.jiyun.com.xiongmaopindao.adapter.NoScrollViewPager;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLive;
import lzm.jiyun.com.xiongmaopindao.fragment.zbfragment.zb_DirectFragment;
import lzm.jiyun.com.xiongmaopindao.fragment.zbfragment.zb_LiveFragment;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZbFragment extends BaseFragment<LivePresenter, LiveModel> implements LiveContract.View {


    private TabLayout zb_tab;
    private NoScrollViewPager zb_pager;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> lists = new ArrayList<>();
    private zb_LiveFragment zb_liveFragment;
    private String strings="http://api.cntv.cn/video/videolistById?vsid=";
    private String stringss="&n=7&serviceId=panda&o=desc&of=time&p=1";
    public ZbFragment() {
        // Required empty public constructor
    }
    @Override
    protected void initView(View view) {
        zb_tab = (TabLayout) view.findViewById(R.id.zb_tab);
        zb_pager = (NoScrollViewPager) view.findViewById(R.id.zb_pager);
        zb_pager.setScanScroll(false);
        zb_pager.setOffscreenPageLimit(8);

    }

    @Override
    protected void initData() {
        mPresenter.presenter_Method(0,"http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zb;
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
                for (int i = 0; i < tablist.size(); i++) {
                    lists.add(tablist.get(i).getTitle());
                    if (i == 0) {
                        zb_liveFragment = new zb_LiveFragment();
                        list.add(zb_liveFragment);
                    } else {
                        String id = tablist.get(i).getId();
                        zb_DirectFragment zb_directFragment = zb_DirectFragment.newInstance(strings + id + stringss);
                        list.add(zb_directFragment);
                    }
                }
                FragmentTabAdapter fragmentTabAdapter = new FragmentTabAdapter(getActivity().getSupportFragmentManager(), list, lists);
                zb_pager.setAdapter(fragmentTabAdapter);
                zb_tab.setupWithViewPager(zb_pager);
                zb_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
            break;
        }
    }
}
