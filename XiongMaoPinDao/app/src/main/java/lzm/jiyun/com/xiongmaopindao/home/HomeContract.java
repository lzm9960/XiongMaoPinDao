package lzm.jiyun.com.xiongmaopindao.home;

import lzm.jiyun.com.xiongmaopindao.base.BaseModel;
import lzm.jiyun.com.xiongmaopindao.base.BasePresenter;
import lzm.jiyun.com.xiongmaopindao.base.BaseView;

/**
 * Created by lenovo on 2017/12/19.
 */

public interface HomeContract {

    interface View extends BaseView {
        void view_Method(String string);
    }

    interface Model extends BaseModel {
        void model_Method(String url,HomeMp mp);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {
        public abstract void presenter_Method(String url);
    }
}