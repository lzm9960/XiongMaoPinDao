package lzm.jiyun.com.xiongmaopindao.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzm.jiyun.com.xiongmaopindao.utlis.Apps;
import lzm.jiyun.com.xiongmaopindao.utlis.TUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {

    public P mPresenter;
    public M mModel;
    private View view;

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            isVisibles();
//            isVisibleToUser = false;
//        } else {
//
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Apps.baseFragment = this;
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);

        if (this instanceof BaseView) {
            mPresenter.setVM(mModel, this);
        }

        view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    protected abstract void initView(View view);

    protected abstract void initData();

    protected abstract int getLayoutId();

//    public void isVisibles() {
//        LanJia();
//    }

//    protected abstract void LanJia();
}
