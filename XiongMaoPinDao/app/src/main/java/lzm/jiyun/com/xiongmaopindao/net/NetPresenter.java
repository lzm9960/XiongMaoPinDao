package lzm.jiyun.com.xiongmaopindao.net;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
* Created by TMVPHelper on 2017/12/18
*/
public class NetPresenter extends NetContract.Presenter{

    @Override
    public void presenter_Method() {
        baseModel.model_Method(new NetMp() {
            @Override
            public void metMp_Method(ArrayList<Fragment> fragments) {
                baseView.view_Method(fragments);
            }
        });
    }
}