package lzm.jiyun.com.xiongmaopindao.fragment.zbfragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.FragmentTabAdapter;
import lzm.jiyun.com.xiongmaopindao.adapter.NoScrollViewPager;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLive;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLivelive;
import lzm.jiyun.com.xiongmaopindao.fragment.zbfragment.bfragment.ZbDuo_Fragment;
import lzm.jiyun.com.xiongmaopindao.fragment.zbfragment.bfragment.ZbLiao_Fragment;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class zb_LiveFragment extends BaseFragment<LivePresenter, LiveModel> implements LiveContract.View {


    private ImageView zblive_img1;
    private TextView zblive_title;
    private ImageView zblive_img2;
    private TextView zblive_te1;
    private TextView zblive_content;
    private TabLayout zblive_tab;
    private NoScrollViewPager zblive_pager;
    private Boolean boo;
    private FragmentTabAdapter fragmentTab;
    private BaseLivelive.BookmarkBean bookmark;

    public zb_LiveFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        zblive_img1 = (ImageView) view.findViewById(R.id.zblive_img1);
        zblive_title = (TextView) view.findViewById(R.id.zblive_title);
        zblive_img2 = (ImageView) view.findViewById(R.id.zblive_img2);
        zblive_te1 = (TextView) view.findViewById(R.id.zblive_te1);
        zblive_content = (TextView) view.findViewById(R.id.zblive_content);
        zblive_tab = (TabLayout) view.findViewById(R.id.zblive_tab);
        zblive_pager = (NoScrollViewPager) view.findViewById(R.id.zblive_pager);
        zblive_pager.setOffscreenPageLimit(2);
        mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
//        zblive_pager.setScanScroll(false);
    }

    @Override
    protected void initData() {
//        if (fragment.isEmpty()&&frstring.isEmpty()){
//            mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
//        }else{
//            fragment.clear();
//            frstring.clear();
//            mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
//        }

//        Bundle arguments = getArguments();
//        String abc = arguments.getString("abc");
//        mPresenter.presenter_Method(abc);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zb__live;
    }

//    @Override
//    protected void LanJia() {
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
//            }
//        });
//    }

    private void initImge() {
        boo = true;
        zblive_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boo == true) {
                    zblive_img2.setImageResource(R.mipmap.live_china_detail_up);
                    zblive_te1.setVisibility(View.VISIBLE);
                    zblive_content.setVisibility(View.VISIBLE);
                    boo = false;
                } else if (boo == false) {
                    zblive_img2.setImageResource(R.mipmap.live_china_detail_down);
                    zblive_te1.setVisibility(View.GONE);
                    zblive_content.setVisibility(View.GONE);
                    boo = true;
                }
            }
        });
    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type) {
            case 0:
                if (string != null) {
                    BaseLive baseLive = gson.fromJson(string, BaseLive.class);
                    List<BaseLive.TablistBean> tablist = baseLive.getTablist();
                    String url = tablist.get(0).getUrl();
                    mPresenter.presenter_Method(1, url);
                }
                break;
            case 1:
                if (string != null) {
                    BaseLivelive baseLivelive = gson.fromJson(string, BaseLivelive.class);
                    List<BaseLivelive.LiveBean> live = baseLivelive.getLive();
                    for (int i = 0; i < live.size(); i++) {
                        Glide.with(getActivity()).load(live.get(i).getImage()).into(zblive_img1);
                        zblive_title.setText(live.get(i).getTitle());
                        zblive_content.setText(live.get(i).getBrief());
                    }
                    initImge();
                    bookmark = baseLivelive.getBookmark();
                    iniitTab(bookmark);
                }
                break;
        }
    }

    private void iniitTab(BaseLivelive.BookmarkBean bookmark) {
//        if ((fragment.size() > 0 && fragment != null) && (frstring.size() > 0 && frstring != null)) {
//            fragmentTab = new FragmentTabAdapter(getActivity().getSupportFragmentManager(), fragment, frstring);
//            zblive_pager.setAdapter(fragmentTab);
//            zblive_tab.setupWithViewPager(zblive_pager);
//        } else {
         ArrayList<Fragment> fragment = new ArrayList<>();
         ArrayList<String> frstring = new ArrayList<>();
        List<BaseLivelive.BookmarkBean.MultipleBean> multiple = bookmark.getMultiple();
        List<BaseLivelive.BookmarkBean.WatchTalkBean> watchTalk = bookmark.getWatchTalk();
        String title = multiple.get(0).getTitle();
        String titles = watchTalk.get(0).getTitle();
        frstring.add(title);
        frstring.add(titles);
        fragment.add(new ZbDuo_Fragment());
        fragment.add(new ZbLiao_Fragment());
        fragmentTab = new FragmentTabAdapter(getActivity().getSupportFragmentManager(), fragment, frstring);
        zblive_pager.setAdapter(fragmentTab);
        zblive_tab.setupWithViewPager(zblive_pager);
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser==true) {
//            mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
//        }
//    }
}
