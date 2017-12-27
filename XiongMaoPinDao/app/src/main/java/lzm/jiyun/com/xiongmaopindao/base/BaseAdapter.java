package lzm.jiyun.com.xiongmaopindao.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/19.
 */

public abstract class BaseAdapter<M> extends RecyclerView.Adapter<BaseAdapter.Myhodel> {
    private List<M> list=new ArrayList<>();
    private OnClike onClike;
    public BaseAdapter(List<M> list) {
        this.list = list;
    }

    @Override
    public Myhodel onCreateViewHolder(ViewGroup parent, int viewType) {
        Myhodel myhodel = Myhodel.get(parent, getLayoutId());
        return myhodel;
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(Myhodel holder, final int position) {
        convaer(holder,list,position);
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClike.setOnClike(view,position);
            }
        });
    }

    protected abstract void convaer(Myhodel holder, List<M> list, int position);

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Myhodel extends RecyclerView.ViewHolder {
        private ImageView img_1;
        private TextView te_1;
        private View mView;
        private final SparseArray<View> viewArray;
        private static Context context;

        public Myhodel(View itemView) {
            super(itemView);
            this.mView=itemView;
            viewArray = new SparseArray<>();
//            te_1=(TextView)itemView.findViewById(R.id.login);
//            img_1=(ImageView)itemView.findViewById(R.id.password);
        }
        //加载布局
        public static Myhodel get(ViewGroup parent,int resource){
            context = parent.getContext();
            View inflate = LayoutInflater.from(context).inflate(resource, null);
            return new Myhodel(inflate);
        }
        public <T extends View> T getView(int id){
            //从集合里面查数据
            View view = viewArray.get(id);
            //判断是否为空
            if (view==null){
                //为空的话就就将控件添加到集合中
                view = mView.findViewById(id);
                viewArray.put(id,view);
            }
            //不为空直接返回该空间
            return (T)view;
        }
        public void setText(int id,String value){
            ((TextView)getView(id)).setText(value);
        }
        public void setImage(int id,String value){
            Glide.with(context).load(value).into((ImageView)getView(id));
        }
        public void setImageBen(int id,int value){
            ((ImageView)getView(id)).setImageResource(value);
        }
        public void setVstext(int id){
            ((TextView)getView(id)).setVisibility(View.GONE);
        }
        public void setVstextXian(int id){
            ((TextView)getView(id)).setVisibility(View.VISIBLE);
        }
        public void setVsimage(int id){
            ((ImageView)getView(id)).setVisibility(View.GONE);
        }
        public void setonlikelist(int id, View.OnClickListener onClickListener){
            ((ImageView)getView(id)).setOnClickListener(onClickListener);
        }
        public View getItemView(){
            return mView;
        }
    }
    public interface OnClike{
        void setOnClike(View view, int position);
    }
    public void setOnClikeList(OnClike onClike){
        this.onClike=onClike;
    }
}
