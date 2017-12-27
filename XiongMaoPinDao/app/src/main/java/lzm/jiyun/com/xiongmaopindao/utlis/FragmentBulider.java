package lzm.jiyun.com.xiongmaopindao.utlis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import lzm.jiyun.com.xiongmaopindao.base.BaseFragment;

/**
 * Created by lenovo on 2017/12/23.
 */

public class FragmentBulider {
    private static  volatile FragmentBulider fragmentBuilder;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private BaseFragment instance;

    public FragmentBulider() {

    }

    public static FragmentBulider getInstance() {
        if (fragmentBuilder == null) {
            synchronized (FragmentBulider.class){
                fragmentBuilder=new FragmentBulider();
            }
        }
        return fragmentBuilder;
    }


    public FragmentBulider init(){
        manager = Apps.baseActivity.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        return this;
    }


    public FragmentBulider add(int containerId,Class<? extends BaseFragment> fragmentClass,boolean childFragment){

        //使用Fragment名字设置一个tag值
        String tag=fragmentClass.getSimpleName();
        //使用tag值来判断当前的Fragment是否实例化了
        fragment = (BaseFragment) manager.findFragmentByTag(tag);

        //判断拿到的
        if (fragment == null) {
            try {
                //使用单利方法来创建一个Fragmengt对象
                fragment = fragmentClass.newInstance();
                //然后调用add方法添加到容器里面
                transaction.add(containerId,fragment,tag);
                //调用添加回退栈方法添加到栈管理里面

                transaction.addToBackStack(tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        if (!childFragment){
            if (Apps.baseFragment != null) {
                transaction.hide(Apps.baseFragment);
            }
        }


        //调用show方法显示当前的fragment

        transaction.show(fragment);


        return this;
    }


    public void Builder(){

        Apps.baseFragment= (BaseFragment) fragment;

        transaction.commit();
    }
}
