package lzm.jiyun.com.xiongmaopindao.base;

/**
 * Created by lenovo on 2017/12/18.
 */
public abstract class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;

    public void setVM(M m, V v) {
        baseModel = m;
        baseView = v;
    }
}
