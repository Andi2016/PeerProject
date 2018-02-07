package com.android.andi.peerproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Andi Xu on 2/6/18.
 */

public class MyAdapter extends BaseAdapter{

    private Context mContext;
    private LinkedList<String> functions;


    public MyAdapter(LinkedList<String> functions, Context mContext){
        this.mContext=mContext;
        this.functions=functions;
    }

    @Override
    public int getCount() {
        return functions.size();
    }

    @Override
    public Object getItem(int position) {
        return functions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup,false);
            holder = new ViewHolder();
            holder.txt_content = convertView.findViewById(R.id.txt_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txt_content.setText(functions.get(position));

        return convertView;
    }




    private class ViewHolder{
        TextView txt_content;
    }



}
