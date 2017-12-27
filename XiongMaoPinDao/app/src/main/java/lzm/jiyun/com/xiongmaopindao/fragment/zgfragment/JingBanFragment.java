package lzm.jiyun.com.xiongmaopindao.fragment.zgfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;
import lzm.jiyun.com.xiongmaopindao.entity.entityzg.BaseZgLive;
import lzm.jiyun.com.xiongmaopindao.live.LiveContract;
import lzm.jiyun.com.xiongmaopindao.live.LiveModel;
import lzm.jiyun.com.xiongmaopindao.live.LivePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class JingBanFragment extends BaseFragment<LivePresenter,LiveModel> implements LiveContract.View{


    private ImageView livezg_img;
    private TextView livezg_title;
    private ImageView livezg_img2;
    private Boolean boo;
    private TextView livezg_content;

    public JingBanFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        livezg_img = (ImageView) view.findViewById(R.id.livezg_img);
        livezg_title = (TextView) view.findViewById(R.id.livezg_title);
        livezg_content = (TextView) view.findViewById(R.id.livezg_content);
        livezg_img2 = (ImageView) view.findViewById(R.id.livezg_img2);
    }

    @Override
    protected void initData() {
        initShuJu();
        boo = true;
        livezg_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boo == true) {
                    livezg_img2.setImageResource(R.mipmap.live_china_detail_up);
                    livezg_content.setVisibility(View.VISIBLE);
                    boo = false;
                } else if (boo == false) {
                    livezg_img2.setImageResource(R.mipmap.live_china_detail_down);
                    livezg_content.setVisibility(View.GONE);
                    boo = true;
                }
            }
        });
    }

    private void initShuJu() {
        Bundle arguments = getArguments();
        String url = arguments.getString("url");
        Log.e("中古", url );
        mPresenter.presenter_Method(0,url);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_jing_ban;
    }

    @Override
    public void view_Method(String string, int type) {
        Gson gson = new Gson();
        switch (type){
            case 0:
                BaseZgLive baseZgLive = gson.fromJson(string, BaseZgLive.class);
                List<BaseZgLive.LiveBean> live = baseZgLive.getLive();
                Log.e("中古1", live.toString() );
                String image = live.get(0).getImage();
                Log.e("中古2", image );
                    livezg_img.setImageResource(R.mipmap.aa);
//                Glide.with(getContext().getApplicationContext()).load(image).into(livezg_img);
                    livezg_title.setText(live.get(0).getTitle());
                    livezg_content.setText(live.get(0).getBrief());
                break;
        }
    }

    public static JingBanFragment newInstance(String s) {
        Bundle args = new Bundle();
        args.putString("url",s);
        JingBanFragment fragment = new JingBanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
