package com.example.app2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.app2.R;
import com.example.app2.bean.MyBean;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyBean.ResultsBean> list;
    private Context context;

    public MyAdapter(ArrayList<MyBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<MyBean.ResultsBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_my, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(list.get(i).getUrl()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dianJi!=null) {
                    dianJi.jisnTing(i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
    private DianJi dianJi;

    public void setDianJi(DianJi dianJi) {
        this.dianJi = dianJi;
    }

    public interface DianJi{
        void jisnTing(int position);
    }
}
