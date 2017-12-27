package com.example.dame.Button2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dame.R;


public class Login_Two extends AppCompatActivity implements View.OnClickListener {


    private ImageView Back_Two;
    private RelativeLayout relativeLayout;
    private RecyclerView Recy_two;

    /**
     * 观看历史页面
     * 空的
     * background
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__twoo);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Back_Two:
                Intent intent = new Intent(Login_Two.this, Login.class);
                startActivity(intent);
        }
    }

    private void initView() {

        Back_Two = (ImageView) findViewById(R.id.Back_Two);
        Back_Two.setOnClickListener(this);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        relativeLayout.setOnClickListener(this);
        Recy_two = (RecyclerView) findViewById(R.id.Recy_two);
        Recy_two.setOnClickListener(this);
    }


}
