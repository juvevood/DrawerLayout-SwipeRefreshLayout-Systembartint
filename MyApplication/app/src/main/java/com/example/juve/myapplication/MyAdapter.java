package com.example.juve.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyAdapter extends BaseAdapter
{
    private String[] mPlanetTitles;
    private List<Map<String, Object>> mData;
    private Context context;
    //ViewHolder静态类
    static class ViewHolder
    {
        public ImageView img;
        public TextView title;
    }

    private LayoutInflater mInflater = null;
    public MyAdapter(Context context)
    {
        mPlanetTitles = context.getResources().getStringArray(R.array.planets_array);
        mData=getData();
        //根据context上下文加载布局，这里的是Demo17Activity本身，即this
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        //How many items are in the data set represented by this Adapter.
        //在此适配器中所代表的数据集中的条目数
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        // Get the data item associated with the specified position in the data set.
        //获取数据集中与指定索引对应的数据项
        return position;
    }

    @Override
    public long getItemId(int position) {
        //Get the row id associated with the specified position in the list.
        //获取在列表中与指定索引对应的行id
        return position;
    }

    //Get a View that displays the data at the specified position in the data set.
    //获取一个在数据集中指定索引的视图来显示数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //如果缓存convertView为空，则需要创建View
        if(convertView == null)
        {
            holder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
            holder.img = (ImageView)convertView.findViewById(R.id.image);
            holder.title = (TextView)convertView.findViewById(R.id.text1);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
        holder.title.setText((String)mData.get(position).get("title"));

        return convertView;
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i=0;i<mPlanetTitles.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title", mPlanetTitles[i].toString());
            map.put("img", R.drawable.ic_action_about);
            list.add(map);
        }

        return list;
    }
}
