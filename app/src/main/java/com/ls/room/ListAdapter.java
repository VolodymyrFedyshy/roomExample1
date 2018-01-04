package com.ls.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created on 03/01/2018.
 */

public class ListAdapter extends ArrayAdapter<User> {
    private ArrayList<User> dataSet;
    private Context mContext;

    static class ViewHolder {
        TextView txtName;
        TextView txtType;
    }

    public ListAdapter(ArrayList<User> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.row_item, parent, false);

        viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
        viewHolder.txtType = (TextView) convertView.findViewById(R.id.mail);

        viewHolder.txtName.setText(getItem(position).name);
        viewHolder.txtType.setText(getItem(position).email);

        return convertView;
    }
}
