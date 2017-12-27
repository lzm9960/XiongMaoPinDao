package lzm.jiyun.com.xiongmaopindao.adapter.zbadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLiao;

/**
 * Created by lenovo on 2017/12/21.
 */

public class Zb_LiaoAdapter extends BaseAdapter<BaseLiao.DataBean.ContentBean> {
    public Zb_LiaoAdapter(List<BaseLiao.DataBean.ContentBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zblive_liao;
    }

    @Override
    protected void convaer(Myhodel holder, List<BaseLiao.DataBean.ContentBean> list, int position) {
        holder.setText(R.id.liao_te1,list.get(position).getAuthor());
        holder.setText(R.id.liao_te3,list.get(position).getMessage());
    }
}
