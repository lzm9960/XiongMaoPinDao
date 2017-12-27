package lzm.jiyun.com.xiongmaopindao.fragment;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.jiyun.com.day07_greendao.AlllistBeanDao;
import com.jiyun.com.day07_greendao.TablistBeanDao;

import java.util.ArrayList;
import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.FragmentTabAdapter;
import lzm.jiyun.com.xiongmaopindao.adapter.NoScrollViewPager;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.base.GreenDAo;
import lzm.jiyun.com.xiongmaopindao.entity.entityzg.AlllistBean;
import lzm.jiyun.com.xiongmaopindao.entity.entityzg.BaseZg;
import lzm.jiyun.com.xiongmaopindao.entity.entityzg.TablistBean;
import lzm.jiyun.com.xiongmaopindao.fragment.zgfragment.JingBanFragment;
import lzm.jiyun.com.xiongmaopindao.fragment.zgfragment.MainZgActivity;
import lzm.jiyun.com.xiongmaopindao.fragment.zgfragment.TongYFragment;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZgFragment extends BaseFragment<LivePresenter, LiveModel> implements LiveContract.View {


    private TabLayout zg_tab;
    private ImageView zg_imge;
    private NoScrollViewPager zg_pager;
    private AlllistBeanDao dao;
    private TablistBeanDao daos;

    public ZgFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        zg_tab = (TabLayout) view.findViewById(R.id.zg_tab);
        zg_imge = (ImageView) view.findViewById(R.id.zg_imge);
        zg_pager = (NoScrollViewPager) view.findViewById(R.id.zg_pager);
        zg_pager.setScanScroll(false);
        dao = GreenDAo.getTan(getActivity()).getDao();
        daos = GreenDAo.getTan(getActivity()).getDaos();
        zg_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void initData() {
        mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");
        zg_imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentBulider.getInstance().init().add(R.id.zg_fragment, DuoFragment.class, false).Builder();
                getActivity().startActivityForResult(new Intent(getActivity(), MainZgActivity.class),0);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zg;
    }
    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        List<TablistBean> tablist = daos.queryBuilder().list();
        if (tablist.size() > 0 && tablist != null) {
             ArrayList<Fragment> tabfragment = new ArrayList<>();
             ArrayList<String> tablists = new ArrayList<>();
            for (int i = 0; i < tablist.size(); i++) {
                String title = tablist.get(i).getTitle();
                tablists.add(title);
                if (title.equals("精编直播")) {
                    String url = tablist.get(i).getUrl();
                    JingBanFragment jingBanFragment = JingBanFragment.newInstance(url);
                    tabfragment.add(jingBanFragment);
                } else {
                    String url = tablist.get(i).getUrl();
                    TongYFragment tongYFragment = TongYFragment.newInstance(url);
                    tabfragment.add(tongYFragment);
                }
            }
            FragmentTabAdapter fragmentTabAdapter = new FragmentTabAdapter(getActivity().getSupportFragmentManager(), tabfragment, tablists);
            zg_pager.setAdapter(fragmentTabAdapter);
            zg_tab.setupWithViewPager(zg_pager);
        } else {
            switch (type){
                case 0:
                    ArrayList<Fragment> tab = new ArrayList<>();
                    ArrayList<String> tabs= new ArrayList<>();
                    BaseZg baseZg = gson.fromJson(string, BaseZg.class);
                    List<TablistBean> tablist1 = baseZg.getTablist();
                    for (int i = 0; i < tablist1.size(); i++) {
                        String title = tablist1.get(i).getTitle();
                        tabs.add(title);
                        if (title.equals("精编直播")) {
                            String url = tablist1.get(i).getUrl();
                            JingBanFragment jingBanFragment = JingBanFragment.newInstance(url);
                            tab.add(jingBanFragment);
                        } else {
                            String url = tablist1.get(i).getUrl();
                            TongYFragment tongYFragment = TongYFragment.newInstance(url);
                            tab.add(tongYFragment);
                        }
                    }
                    FragmentTabAdapter fragmentTabAdapter = new FragmentTabAdapter(getActivity().getSupportFragmentManager(), tab, tabs);
                    zg_pager.setAdapter(fragmentTabAdapter);
                    zg_tab.setupWithViewPager(zg_pager);
                    daos.insertInTx(tablist1);
                    BaseZg baseZgs = gson.fromJson(string, BaseZg.class);
                    List<AlllistBean> alllist = baseZgs.getAlllist();
                    alllist.removeAll(tablist1);
                    dao.insertInTx(alllist);
                    break;
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");
    }
}
