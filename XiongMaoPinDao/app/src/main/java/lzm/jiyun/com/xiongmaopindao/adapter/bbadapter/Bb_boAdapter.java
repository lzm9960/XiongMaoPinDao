package lzm.jiyun.com.xiongmaopindao.adapter.bbadapter;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.entiygun.BaseBobitem;

/**
 * Created by lenovo on 2017/12/22.
 */

public class Bb_boAdapter extends BaseAdapter<BaseBobitem.ListBean> {
    public Bb_boAdapter(List<BaseBobitem.ListBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.bbitem;
    }

    @Override
    protected void convaer(Myhodel holder, List<BaseBobitem.ListBean> list, int position) {
        holder.setImage(R.id.bb_imge,list.get(position).getPicurl());
        holder.setText(R.id.bb_te1,list.get(position).getTitle());
//        holder.setText(R.id.bb_te2,list.get(position).getTitle());
        if (list.size()-1==position){
            holder.setVstext(R.id.bb_te3);
        }
    }
}
