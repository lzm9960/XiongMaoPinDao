package lzm.jiyun.com.xiongmaopindao.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.adapter.Sy_GungAdapter;
import lzm.jiyun.com.xiongmaopindao.adapter.Sy_XinCAdapter;
import lzm.jiyun.com.xiongmaopindao.adapter.Sy_YikAdapter;
import lzm.jiyun.com.xiongmaopindao.adapter.Sy_ZhongGAdapter;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.Base;
import lzm.jiyun.com.xiongmaopindao.entity.BaseGg;
import lzm.jiyun.com.xiongmaopindao.entity.BaseYk;
import lzm.jiyun.com.xiongmaopindao.home.HomeContract;
import lzm.jiyun.com.xiongmaopindao.home.HomeModel;
import lzm.jiyun.com.xiongmaopindao.home.HomePresenter;
import lzm.jiyun.com.xiongmaopindao.network.Callbacks;
import lzm.jiyun.com.xiongmaopindao.network.Okhttp;
import lzm.jiyun.com.xiongmaopindao.utlis.GlideImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyFragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View {


    private Banner sy_banner;
    private ImageView sy_image2;
    private TextView sy_te_1;
    private TextView sy_te2;
    private TextView sy_te_3;
    private TextView sy_te4;
    private RecyclerView sy_recyXc;
    private RecyclerView sy_recyYk;
    private RecyclerView sy_recyGg;
    private RecyclerView sy_recyZg;
    private String image;
    private TextView bannerTitle;
    private String listUrl;
    private SwipeRefreshLayout swi;

    public SyFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView(View view) {
        sy_banner = (Banner) view.findViewById(R.id.sy_banner);
        sy_image2 = (ImageView) view.findViewById(R.id.sy_image2);
        sy_te_1 = (TextView) view.findViewById(R.id.sy_te_1);
        sy_te2 = (TextView) view.findViewById(R.id.sy_te2);
        sy_te_3 = (TextView) view.findViewById(R.id.sy_te_3);
        sy_te4 = (TextView) view.findViewById(R.id.sy_te4);
        sy_recyXc = (RecyclerView) view.findViewById(R.id.sy_recyXc);
        sy_recyYk = (RecyclerView) view.findViewById(R.id.sy_recyYk);
        sy_recyGg = (RecyclerView) view.findViewById(R.id.sy_recyGg);
        sy_recyZg = (RecyclerView) view.findViewById(R.id.sy_recyZg);
        bannerTitle = (TextView) view.findViewById(R.id.sy_titles);
        swi = (SwipeRefreshLayout) view.findViewById(R.id.swi);
        mPresenter.presenter_Method("http://www.ipanda.com/kehuduan/shouye/index.json");
    }

    @Override
    protected void initData() {
        swi.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.presenter_Method("http://www.ipanda.com/kehuduan/shouye/index.json");
                swi.setRefreshing(false);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sy;
    }

    @Override
    public void view_Method(String string) {
        List<String> imaglist = new ArrayList<String>();
        Gson gson = new Gson();
        Base base = gson.fromJson(string, Base.class);
        List<Base.DataBean.BigImgBean> bigImg = base.getData().getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            image = bigImg.get(i).getImage();
            imaglist.add(image);
            bannerTitle.setText(bigImg.get(i).getTitle());
        }
        sy_banner.setImages(imaglist)//添加图片集合或图片url集合
                .setDelayTime(2000)//设置轮播时间
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)//指示器样式
                .setImageLoader(new GlideImage())//加载图片
                .setIndicatorGravity(BannerConfig.RIGHT)//设置指示器位置
                .start();
        initBoShi(base);
        initXinChang(base);
        initYiKe(base);
        initGungun(base);
        initZhongguo(base);
    }

    private void initZhongguo(Base base) {
        Base.DataBean.ChinaliveBean chinalive = base.getData().getChinalive();
        List<Base.DataBean.ChinaliveBean.ListBeanX> list = chinalive.getList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        sy_recyZg.setLayoutManager(gridLayoutManager);
        Sy_ZhongGAdapter sy_zhongGAdapter = new Sy_ZhongGAdapter(list);
        sy_recyZg.setAdapter(sy_zhongGAdapter);
    }

    private void initGungun(Base base) {
        List<Base.DataBean.ListBeanXX> list = base.getData().getList();
        for (int i = 0; i < list.size(); i++) {
            listUrl = list.get(i).getListUrl();
        }
        Okhttp.getTran().sendGet(listUrl, new Callbacks() {
            @Override
            public void callback_Method(String string) {
                Gson gson = new Gson();
                BaseGg baseGg = gson.fromJson(string, BaseGg.class);
                List<BaseGg.ListBean> lists = baseGg.getList();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                sy_recyGg.setLayoutManager(linearLayoutManager);
                Sy_GungAdapter sy_gungAdapter = new Sy_GungAdapter(lists);
                sy_recyGg.setAdapter(sy_gungAdapter);
            }
        });

    }

    private void initYiKe(Base base) {
        Base.DataBean.CctvBean cctv = base.getData().getCctv();
        String listurl = cctv.getListurl();
        Okhttp.getTran().sendGet(listurl, new Callbacks() {
            @Override
            public void callback_Method(String string) {
                Gson gson = new Gson();
                BaseYk baseYk = gson.fromJson(string, BaseYk.class);
                List<BaseYk.ListBean> list = baseYk.getList();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
                sy_recyYk.setLayoutManager(gridLayoutManager);
                Sy_YikAdapter sy_yikAdapter = new Sy_YikAdapter(list);
                sy_recyYk.setAdapter(sy_yikAdapter);
            }
        });
    }

    private void initXinChang(Base base) {
        List<Base.DataBean.PandaliveBean.ListBean> list = base.getData().getPandalive().getList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        sy_recyXc.setLayoutManager(gridLayoutManager);
        Sy_XinCAdapter sy_xinCAdapter = new Sy_XinCAdapter(list);
        sy_recyXc.setAdapter(sy_xinCAdapter);
    }

    private void initBoShi(Base base) {
        Base.DataBean.PandaeyeBean pandaeye = base.getData().getPandaeye();
        Glide.with(getActivity()).load(pandaeye.getPandaeyelogo()).into(sy_image2);
        List<Base.DataBean.PandaeyeBean.ItemsBean> items = pandaeye.getItems();
        sy_te_1.setText(items.get(0).getBrief());
        sy_te2.setText(items.get(0).getTitle());
        sy_te_3.setText(items.get(1).getBrief());
        sy_te4.setText(items.get(1).getTitle());
    }

}
