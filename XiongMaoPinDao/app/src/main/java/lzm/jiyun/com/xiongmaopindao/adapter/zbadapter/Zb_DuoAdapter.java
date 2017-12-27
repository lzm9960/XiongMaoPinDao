package lzm.jiyun.com.xiongmaopindao.adapter.zbadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.BaseLive_Duo;

/**
 * Created by lenovo on 2017/12/20.
 */

public class Zb_DuoAdapter extends BaseAdapter<BaseLive_Duo.ListBean> {
    public Zb_DuoAdapter(List<BaseLive_Duo.ListBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zblive_duo;
    }

    @Override
    protected void convaer(Myhodel holder, List<BaseLive_Duo.ListBean> list, int position) {
        holder.setImage(R.id.zbduo_image,list.get(position).getImage());
        holder.setText(R.id.zbduo_title,list.get(position).getTitle());
    }
}
