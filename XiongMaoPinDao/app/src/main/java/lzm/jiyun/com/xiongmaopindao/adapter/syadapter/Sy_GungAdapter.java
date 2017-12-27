package lzm.jiyun.com.xiongmaopindao.adapter.syadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.BaseGg;

/**
 * Created by lenovo on 2017/12/19.
 */

public class Sy_GungAdapter extends BaseAdapter<BaseGg.ListBean> {
    public Sy_GungAdapter(List<BaseGg.ListBean>  list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sy_gung;
    }

    @Override
    protected void convaer(Myhodel holder, List<BaseGg.ListBean> list, int position) {
        holder.setImage(R.id.gung_img,list.get(position).getImage());
        holder.setText(R.id.gung_te1,list.get(position).getVideoLength());
        holder.setText(R.id.gung_te2,list.get(position).getTitle());
        holder.setText(R.id.gung_te3,list.get(position).getDaytime());
    }
}
