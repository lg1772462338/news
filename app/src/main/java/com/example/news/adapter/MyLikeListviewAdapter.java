package com.example.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.entity.News;
import com.example.news.entity.NewsBean;
import com.example.news.utils.CacheUtil;

import java.util.List;

/**
 * Created by c8469 on 2016/12/14.
 */

public class MyLikeListviewAdapter extends BaseAdapter {

    private Context context;
    public List<News> datas;

    public MyLikeListviewAdapter(Context context, List<News> datas){

        this.context = context;
        this.datas = datas;

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        ViewHolder holder = null;

        if(convertView == null){

            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_listview_news_fragment_activity_main, null);
            holder.iv_pic = (ImageView) view.findViewById(R.id.iv_pic_news_fragment_activity_main);
            holder.tv_title = (TextView) view.findViewById(R.id.tv_title_news_fragment_activity_main);
            holder.tv_date = (TextView) view.findViewById(R.id.tv_date_news_fragment_activity_main);

            view.setTag(holder);

        }else{

            view = convertView;
            holder = (ViewHolder) view.getTag();

        }



        String readedUrl = CacheUtil.getStringFromSp(context, CacheUtil.READED);

        if(readedUrl.contains(datas.get(position).getUrl())){

            holder.tv_title.setTextColor(Color.GRAY);
        }else {

            holder.tv_title.setTextColor(Color.BLACK);

        }


        Glide.with(context).load(datas.get(position).getImg()).crossFade().into(holder.iv_pic);

        holder.tv_title.setText(datas.get(position).getTitle());
        holder.tv_date.setText(datas.get(position).getDate());


        return view;
    }

    class ViewHolder{

        ImageView iv_pic;
        TextView tv_title;
        TextView tv_date;

    }

}
