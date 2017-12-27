package com.example.dame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.dame.Button1.Interaction;
import com.example.dame.Button2.Login;

public class MainActivity extends AppCompatActivity {

    private ImageView main_imageView_JH;
    private ImageView main_imageView_Login;

    /**
     * 主页面 两个button  点击第一个button跳转到  recycleview和url    第二个button  跳转到登录设置详情页面
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initActivity();
    }

    private void initActivity() {
        main_imageView_JH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 主页面  点击事件跳转到recycleview和url的页面
                 */
                startActivity(new Intent(MainActivity.this, Interaction.class));
            }
        });
        main_imageView_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 主页面  点击事件跳转到登录设置的总页面
                 */
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });


    }


    private void initView() {
        main_imageView_JH = (ImageView) findViewById(R.id.main_imageView_JH);
        main_imageView_Login = (ImageView) findViewById(R.id.main_imageView_Login);
    }
}
