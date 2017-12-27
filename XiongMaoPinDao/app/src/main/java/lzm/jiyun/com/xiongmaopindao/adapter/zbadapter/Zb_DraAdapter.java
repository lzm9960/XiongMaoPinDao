package lzm.jiyun.com.xiongmaopindao.adapter.zbadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.BaseDra;

/**
 * Created by lenovo on 2017/12/21.
 */

public class Zb_DraAdapter extends BaseAdapter<BaseDra.VideoBean> {
    public Zb_DraAdapter(List<BaseDra.VideoBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zb_dra;
    }

    @Override
    protected void convaer(Myhodel holder, List<BaseDra.VideoBean> list, int position) {
        holder.setImage(R.id.dra_img,list.get(position).getImg());
        holder.setText(R.id.dra_te1,list.get(position).getLen());
        holder.setText(R.id.dra_te2,list.get(position).getT());
        holder.setText(R.id.dra_te3,list.get(position).getPtime());
        if (list.size()==position){
            holder.setVstext(R.id.dra_te4);
        }
    }
}
