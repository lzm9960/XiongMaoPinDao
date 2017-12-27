package lzm.jiyun.com.xiongmaopindao.adapter.syadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.BaseYk;

/**
 * Created by lenovo on 2017/12/19.
 */

public class Sy_YikAdapter extends BaseAdapter<BaseYk.ListBean> {
    public Sy_YikAdapter(List<BaseYk.ListBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sy_yike;
    }

    @Override
    protected void convaer(Myhodel holder, List<BaseYk.ListBean> list, int position) {
        holder.setImage(R.id.yk_image,list.get(position).getImage());
        holder.setText(R.id.yk_te1,list.get(position).getVideoLength());
        holder.setText(R.id.yk_te2,list.get(position).getTitle());
        holder.setText(R.id.yk_te3,list.get(position).getDaytime());
    }
}
