package lzm.jiyun.com.xiongmaopindao.base;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.umeng.socialize.UMShareAPI;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.utlis.Apps;
import lzm.jiyun.com.xiongmaopindao.utlis.TUtils;

/**
 * Created by lenovo on 2017/12/18.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    public P mPresenter;
    public M mModel;
    public ImageView too_img1;
    public TextView too_title;
    public ImageView too_img2;
    public ImageView too_img3;
    public FrameLayout too_fragment;
    private Toolbar too;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.setContentView(R.layout.title_activity);
        Apps.baseActivity=this;
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
//        setContentView(getLayoutId());
        initViews();
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);

        if (this instanceof BaseView) {
            mPresenter.setVM(mModel, this);
        }
        initView();
        initData();

    }

    protected abstract void initData();


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
    }

    @Override
    public void setContentView(View view) {
        too_fragment.removeAllViews();
        too_fragment.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    public void setToo_img1(int imgs1) {
        too_img1.setImageResource(imgs1);
    }
    public void setToo_title(String titles) {
        too_title.setText(titles);
    }

    public void setToo_img2(int imgs2) {
        too_img2.setImageResource(imgs2);
        too_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(BaseActivity.this, Interaction.class));
            }
        });

    }

    public void setToo_img3(int imgs3) {
        too_img3.setImageResource(imgs3);
    }
    public abstract int getLayoutId();
    public abstract void initView();


    private void initViews() {
        too_img1 = (ImageView) findViewById(R.id.too_img1);
        too_title = (TextView) findViewById(R.id.too_title);
        too_img2 = (ImageView) findViewById(R.id.too_img2);
        too_img3 = (ImageView) findViewById(R.id.too_img3);
        too_fragment = (FrameLayout) findViewById(R.id.too_fragment);
        too = (Toolbar) findViewById(R.id.too);
        too.setTitle("");
        setSupportActionBar(too);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
