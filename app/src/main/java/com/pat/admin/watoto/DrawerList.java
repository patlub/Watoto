package com.pat.admin.watoto;

/**
 * Created by PATRICK on 8/4/2016.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Belal on 7/22/2015.
 */
public class DrawerList extends ArrayAdapter<String> {
    private String[] names;
    private Integer[] imageid;
    private Activity context;

    public DrawerList(Activity context, String[] names, Integer[] imageid) {
        super(context, R.layout.drawer, names);
        this.context = context;
        this.names = names;
        this.imageid = imageid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.drawer, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.imageView);

        textViewName.setText(names[position]);
        image.setImageResource(imageid[position]);
        return listViewItem;
    }
}