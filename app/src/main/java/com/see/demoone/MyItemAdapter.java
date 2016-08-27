package com.see.demoone;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * 多种风格的item，在一个listview中
 * Created by see on 2016/8/24.
 */
public class MyItemAdapter extends BaseAdapter {
    private Context context = null;
    private List mData;

    public MyItemAdapter(Context context, List mData) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        //title是list数据中一个字段用来区分item的风格
        if (mData.get(position).get(title).toString().charAt(0) == 's') {
            return 0;
        } else {
            return 1;
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        ViewHolderOther viewHolderOther = null;
        if (getItemViewType(position) == 0) {
            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                convertView = layoutInflater.inflate(R.layout.lineinspection_listview_item, null);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_listview_item);
                viewHolder.et = (EditText) convertView.findViewById(R.id.et_listview_item);
                viewHolder.add = (Button) convertView.findViewById(R.id.btnadd_listview_item);
                viewHolder.sub = (Button) convertView.findViewById(R.id.btnsub_listview_item);
                viewHolder.remark = (Button) convertView.findViewById(R.id.btnremark_listview_item);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv.setText(mData.get(position).get(title).toString().substring(1));
            viewHolder.et.setText(mData.get(position).get(info).toString());
            viewHolder.add.setOnClickListener(new MyListener(position, 0));
            viewHolder.sub.setOnClickListener(new MyListener(position, 1));
            viewHolder.remark.setOnClickListener(new MyListener(position, 2));
        } else {
            if (convertView == null) {
                viewHolderOther = new ViewHolderOther();
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                convertView = layoutInflater.inflate(R.layout.lineinspection_listview_itemother, null);
                viewHolderOther.tv = (TextView) convertView.findViewById(R.id.tv_listview_itemother);
                viewHolderOther.et = (EditText) convertView.findViewById(R.id.et_listview_itemother);
                viewHolderOther.remark = (Button) convertView.findViewById(R.id.btnadd_listview_itemother);
                convertView.setTag(viewHolderOther);
            } else {
                viewHolderOther = (ViewHolderOther) convertView.getTag();
            }
            viewHolderOther.tv.setText(mData.get(position).get(title).toString());
            viewHolderOther.et.setText(mData.get(position).get(info).toString());
            viewHolderOther.remark.setOnClickListener(new MyListener(position, 2));
        }
        return convertView;
    }


    //Button响应
    private class MyListener implements View.OnClickListener {
        private int position;
        private int serial;

        public MyListener(int position, int serial) {
            this.position = position;
            this.serial = serial;
        }

        @Override
        public void onClick(View v) {
            switch (serial) {
                case 0:
                    Toast.makeText(context, "第" + position + "行的第一个按钮", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(context, "第" + position + "行的第er个按钮", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(context, "第" + position + "行的第san个按钮", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

    class ViewHolder {
        TextView tv;
        EditText et;
        Button add;
        Button sub;
        Button remark;

    }

    class ViewHolderOther {
        TextView tv;
        EditText et;
        Button remark;

    }

}