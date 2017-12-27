package lzm.jiyun.com.xiongmaopindao.adapter.syadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.Base;

/**
 * Created by lenovo on 2017/12/19.
 */

public class Sy_ZhongGAdapter extends BaseAdapter<Base.DataBean.ChinaliveBean.ListBeanX> {
    public Sy_ZhongGAdapter(List<Base.DataBean.ChinaliveBean.ListBeanX> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sy_zhongg;
    }

    @Override
    protected void convaer(Myhodel holder, List<Base.DataBean.ChinaliveBean.ListBeanX> list, int position) {
        holder.setImage(R.id.zhongg_image,list.get(position).getImage());
        holder.setText(R.id.zhongg_title,list.get(position).getTitle());
    }
}
