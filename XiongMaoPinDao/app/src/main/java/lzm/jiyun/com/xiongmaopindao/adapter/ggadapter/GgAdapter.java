package lzm.jiyun.com.xiongmaopindao.adapter.ggadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.entiygun.BaseGun;

/**
 * Created by lenovo on 2017/12/21.
 */

public class GgAdapter extends BaseAdapter<BaseGun.ListBean> {
    public GgAdapter(List<BaseGun.ListBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.ggfragment;
    }

    @Override
    protected void convaer(Myhodel holder, List<BaseGun.ListBean> list, int position) {
        holder.setImage(R.id.gun_img,list.get(position).getImage());
        holder.setText(R.id.gun_te1,list.get(position).getVideoLength());
        holder.setText(R.id.gun_te2,list.get(position).getTitle());
        holder.setText(R.id.gun_te3,list.get(position).getBrief());
        if (list.size()-1==position){
            holder.setVstext(R.id.gg_te1);
        }
    }
}
