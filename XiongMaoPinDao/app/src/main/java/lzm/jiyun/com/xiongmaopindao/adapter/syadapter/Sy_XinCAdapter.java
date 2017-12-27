package lzm.jiyun.com.xiongmaopindao.adapter.syadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.Base;

/**
 * Created by lenovo on 2017/12/19.
 */

public class Sy_XinCAdapter extends BaseAdapter<Base.DataBean.PandaliveBean.ListBean>{
    public Sy_XinCAdapter(List<Base.DataBean.PandaliveBean.ListBean> list) {
        super(list);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.sy_xiuc;
    }

    @Override
    protected void convaer(Myhodel holder, List<Base.DataBean.PandaliveBean.ListBean> list, int position) {
        holder.setImage(R.id.xiuc_image,list.get(position).getImage());
        holder.setText(R.id.xiuc_title,list.get(position).getTitle());
    }
}
