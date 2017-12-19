package lzm.jiyun.com.xiongmaopindao.net;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import lzm.jiyun.com.xiongmaopindao.base.BaseModel;
import lzm.jiyun.com.xiongmaopindao.base.BasePresenter;
import lzm.jiyun.com.xiongmaopindao.base.BaseView;

/**
 * Created by lenovo on 2017/12/18.
 */

public interface NetContract {

    interface View extends BaseView {
      void view_Method(ArrayList<Fragment> fragments);
    }

    interface Model extends BaseModel {
        void model_Method(NetMp mp);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {
        public abstract void presenter_Method();
    }
}