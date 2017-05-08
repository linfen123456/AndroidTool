package com.example.androidstutytool.androidtool.RecycleView;


import android.app.LauncherActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstutytool.androidtool.R;

import java.util.List;


/**
 * RecycleView自定义列表
 * Created by World on 2017/4/25.
 */

public class RecycleListAdapter extends RecyclerView.Adapter<RecycleListAdapter.ViewHolder> {
    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        private View viewList;
        public ViewHolder(View itemView) {
            super(itemView);
            viewList=itemView;
            imageView=(ImageView)itemView.findViewById(R.id.itemList_img);
            textView=(TextView) itemView.findViewById(R.id.itemList_title);

        }
    }
    public RecycleListAdapter(List<ListItem> list,int layout){
        this.list=list;
        this.layout=layout;
        Log.i("Recycle长度",list.size()+"");
    }
    private List<ListItem> list;
    private int  layout;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        final ViewHolder holder=new ViewHolder(view);

        holder.viewList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                ListItem listItem=list.get(position);
                Toast.makeText(v.getContext(),"你点击了"+position,Toast.LENGTH_SHORT).show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            ListItem listItem=list.get(position);
        holder.imageView.setImageResource(listItem.getImg());
        holder.textView.setText(listItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
