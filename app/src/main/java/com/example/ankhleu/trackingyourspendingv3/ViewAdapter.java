package com.example.ankhleu.trackingyourspendingv3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ankhleu on 2018/2/4.
 */

public class ViewAdapter extends BaseAdapter {

    public String[][] ElementsData;
    public LayoutInflater inflater;
    public int  indentionBase;

    static class ViewHolder{
        LinearLayout rlBorder;
        TextView time;
        TextView subject;
        TextView money;
        TextView note;
    }

    public ViewAdapter(String[][] data,LayoutInflater inflater)
    {
        this.ElementsData=data;
        this.inflater=inflater;
      //  indentionBase=100;
    }




    @Override
    public int getCount() {
       // return 0;
        return ElementsData.length;
    }

    @Override
    public Object getItem(int position) {
        //return null;
        return ElementsData[position];
    }

    @Override
    public long getItemId(int position) {
        //return 0;
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView==null)
        {
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.bill_listview,null);
            holder.time=(TextView)convertView.findViewById(R.id.tvtime);
            holder.subject=(TextView)convertView.findViewById(R.id.tvsubject);
            holder.money=(TextView)convertView.findViewById(R.id.tvmoney);
            holder.note=(TextView)convertView.findViewById(R.id.tvnote);
            holder.rlBorder=(LinearLayout)convertView.findViewById(R.id.llBorder);
            convertView.setTag(holder);
//            holder.time.setText(ElementsData[position][0]);
//            holder.subject.setText(ElementsData[position][1]);
//            holder.money.setText(ElementsData[position][2]);
//            holder.note.setText(ElementsData[position][3]);
            Log.d("holder time","0");
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.time.setText(ElementsData[position][1]);
        holder.subject.setText(ElementsData[position][2]);
        holder.money.setText(ElementsData[position][2]);
        holder.note.setText(ElementsData[position][4]);
        Log.d("holdertime","0" + ElementsData[position][0]); //Log.d+直接顯示資料tag,後面貼上想要出現的數值
        /*        if (ElementsData[position][0].equals("1"))
        {
            holder.time.setText(ElementsData[position][1]);
        holder.subject.setText(ElementsData[position][2]);
        holder.money.setText(ElementsData[position][2]);
        holder.note.setText(ElementsData[position][4]);
        }

        else
        {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.rlBorder.getLayoutParams();
            //lp.setMargins(indentionBase,0, 0,0);//縮牌
        }
*/
        return convertView;
      //  return null;
    }
}
