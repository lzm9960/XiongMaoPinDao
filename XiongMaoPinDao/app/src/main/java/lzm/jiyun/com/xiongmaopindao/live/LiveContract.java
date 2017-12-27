package lzm.jiyun.com.xiongmaopindao.live;

import lzm.jiyun.com.xiongmaopindao.base.BaseModel;
import lzm.jiyun.com.xiongmaopindao.base.BasePresenter;
import lzm.jiyun.com.xiongmaopindao.base.BaseView;

/**
 * Created by lenovo on 2017/12/20.
 */

public interface LiveContract {

    interface View extends BaseView {
        void view_Method(String string, int type);
    }

    interface Model extends BaseModel {
        void model_Method(String url,LiveMp mp);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {
        public abstract void presenter_Method(int type,String url);
    }
}