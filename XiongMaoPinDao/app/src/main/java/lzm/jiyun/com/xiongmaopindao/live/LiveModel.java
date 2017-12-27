package lzm.jiyun.com.xiongmaopindao.live;

import lzm.jiyun.com.xiongmaopindao.network.Callbacks;
import lzm.jiyun.com.xiongmaopindao.network.Okhttp;

import static android.R.attr.type;

/**
* Created by TMVPHelper on 2017/12/20
*/
public class LiveModel implements LiveContract.Model{

    @Override
    public void model_Method(String url, final LiveMp mp) {
        Okhttp.getTran().sendGet(url, new Callbacks() {
            @Override
            public void callback_Method(String string) {
                mp.liveMp_Method(string);
            }
        });
    }
}