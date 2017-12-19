package lzm.jiyun.com.xiongmaopindao.home;

import lzm.jiyun.com.xiongmaopindao.network.Callbacks;
import lzm.jiyun.com.xiongmaopindao.network.Okhttp;

/**
* Created by TMVPHelper on 2017/12/19
*/
public class HomeModel implements HomeContract.Model{

    @Override
    public void model_Method(String url,final HomeMp mp) {
        Okhttp.getTran().sendGet(url, new Callbacks() {
            @Override
            public void callback_Method(String string) {
                mp.home_Method(string);
            }
        });
    }
}