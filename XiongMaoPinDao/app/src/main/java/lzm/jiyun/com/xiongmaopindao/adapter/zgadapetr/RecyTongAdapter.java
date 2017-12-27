package lzm.jiyun.com.xiongmaopindao.adapter.zgadapetr;

import android.view.View;

import java.util.List;

import lzm.jiyun.com.xiongmaopindao.R;
import lzm.jiyun.com.xiongmaopindao.base.BaseAdapter;
import lzm.jiyun.com.xiongmaopindao.entity.entityzg.BaseZgTong;

/**
 * Created by lenovo on 2017/12/26.
 */

public class RecyTongAdapter extends BaseAdapter<BaseZgTong.LiveBean> {
    private Boolean boo;
    public RecyTongAdapter(List<BaseZgTong.LiveBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zgtong;
    }

    @Override
    protected void convaer(final Myhodel holder, List<BaseZgTong.LiveBean> list, int position) {
        holder.setImage(R.id.livezgty_img,list.get(position).getImage());
        holder.setText(R.id.livezgty_title,list.get(position).getTitle());
        holder.setText(R.id.livezgty_content,list.get(position).getBrief());
        boo = true;
        holder.setonlikelist(R.id.livezgty_img2, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boo == true) {
                    holder.setImageBen(R.id.livezgty_img2,R.mipmap.live_china_detail_up);
                    holder.setVstextXian(R.id.livezgty_content);
                    boo = false;
                } else if (boo == false) {
                    holder.setImageBen(R.id.livezgty_img2,R.mipmap.live_china_detail_down);
                    holder.setVstext(R.id.livezgty_content);
                    boo = true;
                }
            }
        });
    }
}
