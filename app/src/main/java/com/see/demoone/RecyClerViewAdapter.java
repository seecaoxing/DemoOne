package com.see.demoone;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by see on 2016/8/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.VH> {

    private List<String> textList;
    private List<String> urlList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<String> textlist, List<String> urlList) {
        this.context = context;
        this.textList = textlist;
        this.urlList = urlList;
    }

    //利用回调的方式设置监听
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener onItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH holder = new VH(LayoutInflater.from(context)
                .inflate(R.layout.item_recyclerview, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        holder.tv.setText(textList.get(position));
        holder.iv.setImageURI(Uri.parse(urlList.get(position)));//使用Fresco显示图片
        //如果设置回调，那么设置点击事件
        if (onItemClickLitener != null)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = holder.getLayoutPosition();
                onItemClickLitener.onItemLongClick(holder.itemView, pos);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView tv;
        SimpleDraweeView iv;

        public VH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.text);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.image_view);
        }
    }

}
