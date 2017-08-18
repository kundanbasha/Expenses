package com.example.root.expenses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 27/5/17.
 */
public class CustomAdapter extends ArrayAdapter<Expense> implements View.OnClickListener {

    List<Expense> data;
    Context mcontext;


    public CustomAdapter(Context context, List<Expense> objects) {
        super(context, R.layout.row, objects);
        this.data=objects;
        this.mcontext=context;
    }

    private static class ViewHolder {
        TextView subjects;
        TextView descrips;
        TextView moneys;
        TextView dates;
    }

    @Override
    public void onClick(View v) {

    }

    private int lastpos=-1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Expense expense=getItem(position);

        ViewHolder viewHolder;
         final View res;

        if (convertView==null){

            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            convertView=layoutInflater.inflate(R.layout.row,parent,false);
            viewHolder.subjects=(TextView)convertView.findViewById(R.id.sub);
            viewHolder.descrips=(TextView)convertView.findViewById(R.id.descrip);
            viewHolder.moneys=(TextView)convertView.findViewById(R.id.dabbu);
            viewHolder.dates=(TextView)convertView.findViewById(R.id.dates);
            res=convertView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
            res=convertView;
        }
        lastpos=position;
        viewHolder.subjects.setText(expense.getSubject());
        viewHolder.descrips.setText(expense.getDescription());
        viewHolder.moneys.setText(expense.getDates());
        viewHolder.dates.setText(expense.getMoneyPaid()+"/-");
        return convertView;
    }
}
