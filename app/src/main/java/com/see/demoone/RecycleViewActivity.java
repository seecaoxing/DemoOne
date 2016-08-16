package com.see.demoone;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**RecylerView的用法
 * Created by see on 2016/8/16.
 */
public class RecycleViewActivity extends Activity {
    private  List<String> textList;
    private  List<String> urlList;
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        textList = new ArrayList<String>();
        for (int i = 0;i<10000;i++)
        {
            textList.add("第"+i+"个item");

        }
        urlList = new ArrayList<String>();
        for (int j = 0; j<2000;j++){
            urlList.add("http://img4.imgtn.bdimg.com/it/u=1270641523,992229015&fm=21&gp=0.jpg");
            urlList.add("http://pic.qiantucdn.com/58pic/16/10/68/01e58PICTZj_1024.jpg");
            urlList.add("http://pic.qiantucdn.com/58pic/17/37/24/15658PICESm_1024.png");
            urlList.add("http://pic.qiantucdn.com/58pic/17/37/24/68258PIC7Xf_1024.jpg");
            urlList.add("http://pic.qiantucdn.com/58pic/16/10/23/81A58PICm6G_1024.jpg");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter = new RecyclerViewAdapter(getApplicationContext(),textList,urlList));



    }


    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.VH> {
        private List<String> textList;
        private List<String> urlList;
        private Context context;
        public RecyclerViewAdapter(Context context , List<String> textlist, List<String> urlList) {
            this.context = context;
            this.textList = textlist;
            this.urlList = urlList;
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            VH holder = new VH(LayoutInflater.from(RecycleViewActivity.this)
                    .inflate(R.layout.item_recyclerview, parent, false));

            return holder;
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.tv.setText(textList.get(position));
            holder.iv.setImageURI(Uri.parse(urlList.get(position)));//使用Fresco显示图片
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
}
