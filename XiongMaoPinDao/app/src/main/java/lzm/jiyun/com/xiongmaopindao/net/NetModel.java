package lzm.jiyun.com.xiongmaopindao.net;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import lzm.jiyun.com.xiongmaopindao.fragment.BbFragment;
import lzm.jiyun.com.xiongmaopindao.fragment.GgFragment;
import lzm.jiyun.com.xiongmaopindao.fragment.SyFragment;
import lzm.jiyun.com.xiongmaopindao.fragment.ZbFragment;
import lzm.jiyun.com.xiongmaopindao.fragment.ZgFragment;

/**
* Created by TMVPHelper on 2017/12/18
*/
public class NetModel implements NetContract.Model{

    @Override
    public void model_Method(NetMp mp) {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SyFragment());
        fragments.add(new ZbFragment());
        fragments.add(new GgFragment());
        fragments.add(new BbFragment());
        fragments.add(new ZgFragment());
        mp.metMp_Method(fragments);
    }
}