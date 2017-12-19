package lzm.jiyun.com.xiongmaopindao;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import lzm.jiyun.com.xiongmaopindao.adapter.FragmentAdapter;
import lzm.jiyun.com.xiongmaopindao.adapter.NoScrollViewPager;
import lzm.jiyun.com.xiongmaopindao.base.BaseActivity;
import lzm.jiyun.com.xiongmaopindao.net.NetContract;
import lzm.jiyun.com.xiongmaopindao.net.NetModel;
import lzm.jiyun.com.xiongmaopindao.net.NetPresenter;

public class MainActivity extends BaseActivity<NetPresenter, NetModel> implements NetContract.View {

    private NoScrollViewPager pager;
    private TextView sy_img;
    private TextView zb_img;
    private TextView gg_img;
    private TextView bb_img;
    private TextView zg_img;
    private View views;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        sy_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                too_title.setVisibility(View.INVISIBLE);
                too_img1.setVisibility(View.VISIBLE);
                too_img2.setVisibility(View.VISIBLE);
                too_img3.setVisibility(View.VISIBLE);
                setToo_img1(R.mipmap.panda_sign);
                setToo_img2(R.mipmap.hudong_sign);
                setToo_img3(R.mipmap.person_sign);
                pager.setCurrentItem(0);
            }
        });
        zb_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                too_title.setVisibility(View.VISIBLE);
                too_img1.setVisibility(View.INVISIBLE);
                too_img2.setVisibility(View.INVISIBLE);
                too_img3.setVisibility(View.VISIBLE);
                setToo_title("熊猫直播");
                setToo_img3(R.mipmap.person_sign);

                pager.setCurrentItem(1);
            }
        });
        gg_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                too_title.setVisibility(View.VISIBLE);
                too_img1.setVisibility(View.INVISIBLE);
                too_img2.setVisibility(View.INVISIBLE);
                too_img3.setVisibility(View.VISIBLE);
                setToo_title("滚滚直播");
                setToo_img3(R.mipmap.person_sign);
                pager.setCurrentItem(2);
            }
        });
        bb_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                too_title.setVisibility(View.VISIBLE);
                too_img1.setVisibility(View.INVISIBLE);
                too_img2.setVisibility(View.INVISIBLE);
                too_img3.setVisibility(View.VISIBLE);
                setToo_title("熊猫播报");
                setToo_img3(R.mipmap.person_sign);
                pager.setCurrentItem(3);
            }
        });
        zg_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                too_title.setVisibility(View.VISIBLE);
                too_img1.setVisibility(View.INVISIBLE);
                too_img2.setVisibility(View.INVISIBLE);
                too_img3.setVisibility(View.VISIBLE);
                setToo_title("直播中国");
                setToo_img3(R.mipmap.person_sign);
                pager.setCurrentItem(4);
            }
        });
    }

    @Override
    public void initView() {
        views = View.inflate(this, R.layout.activity_main, null);
        setContentView(views);
        pager = (NoScrollViewPager) findViewById(R.id.pager);
        pager.setScanScroll(false);
        too_title.setVisibility(View.INVISIBLE);
        too_img1.setVisibility(View.VISIBLE);
        too_img2.setVisibility(View.VISIBLE);
        too_img3.setVisibility(View.VISIBLE);
        setToo_img1(R.mipmap.panda_sign);
        setToo_img2(R.mipmap.hudong_sign);
        setToo_img3(R.mipmap.person_sign);
        pager.setCurrentItem(0);
        sy_img = (TextView) findViewById(R.id.sy_img);
        zb_img = (TextView) findViewById(R.id.zb_img);
        gg_img = (TextView) findViewById(R.id.gg_img);
        bb_img = (TextView) findViewById(R.id.bb_img);
        zg_img = (TextView) findViewById(R.id.zg_img);
        mPresenter.presenter_Method();
    }

    @Override
    public void view_Method(ArrayList<Fragment> fragments) {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(fragmentAdapter);
    }
}
