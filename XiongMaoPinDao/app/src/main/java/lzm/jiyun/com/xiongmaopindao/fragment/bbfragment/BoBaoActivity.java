package lzm.jiyun.com.xiongmaopindao.fragment.bbfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import lzm.jiyun.com.xiongmaopindao.R;

public class BoBaoActivity extends AppCompatActivity {

    private WebView wedbb;
    private RelativeLayout activity_bo_bao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_bao);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String urls = intent.getStringExtra("urls");
        wedbb.loadUrl(url);
        wedbb.loadUrl(urls);
    }

    private void initView() {
        wedbb = (WebView) findViewById(R.id.wedbb);
    }
}
