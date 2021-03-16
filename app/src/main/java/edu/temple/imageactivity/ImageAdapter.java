package edu.temple.imageactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    String[] items;
    ArrayList<Integer> imageitems;

    public ImageAdapter (Context context, String[] items, ArrayList<Integer> imageitems){
        this.context = context;
        this.items = items;
        this.imageitems = imageitems;
    }

    private boolean isTitle(int position){
        //title is at index 0
        return position == 0;
    }

    @Override
    public int getCount() {
        // items + 1 titleview
        //return items.size()+1;
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        if(isTitle(position)){
            return null; //if it is title, return nothing
        }else{
            //return items.get(position + 1); //add 1 because of title view;
            return items[position];
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textview;
        ImageView imageview;

        LinearLayout linearlayout;
        RelativeLayout relativelayout;

        if(convertView == null){
            linearlayout = new LinearLayout(context);
            relativelayout = new RelativeLayout(context);
            textview = new TextView(context);
            imageview = new ImageView(context);

            linearlayout.setOrientation(LinearLayout.HORIZONTAL);
            //textview.setPadding(90,100,45,50);
            textview.setTextSize(18);
            textview.setTextColor(Color.WHITE);
            textview.setGravity(Gravity.CENTER);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);


            //linearlayout.addView(imageview);
            relativelayout.addView(imageview);
            imageview.getLayoutParams().height = 300;
            imageview.getLayoutParams().width = 300;
            //linearlayout.addView(textview);
            relativelayout.addView(textview, params);
        }else{
            //linearlayout = (LinearLayout) convertView;
            relativelayout = (RelativeLayout) convertView;
            imageview = (ImageView) relativelayout.getChildAt(0);
            textview = (TextView) relativelayout.getChildAt(1);
        }

        imageview.setImageResource(imageitems.get(position));
        textview.setText(items[position]);

        //return linearlayout;
        return relativelayout;
    }
    /*
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if(isTitle(position)){
            return getView(position, null, parent);
        }

        TextView textview;
        ImageView imageview;

        LinearLayout linearlayout;

        if(convertView instanceof TextView || convertView == null){
            linearlayout = new LinearLayout(context);
            textview = new TextView(context);
            imageview = new ImageView(context);

            linearlayout.setOrientation(LinearLayout.HORIZONTAL);
            textview.setPadding(10,15,15,15);
            textview.setTextSize(22);

            linearlayout.addView(imageview);
            imageview.getLayoutParams().height = 150;
            imageview.getLayoutParams().width = 150;
            linearlayout.addView(textview);
        }else{
            linearlayout = (LinearLayout) convertView;
            imageview = (ImageView) linearlayout.getChildAt(0);
            textview = (TextView) linearlayout.getChildAt(1);
        }

        imageview.setImageResource(imageitems.get(position - 1));
        textview.setText(items.get(position - 1));

        return linearlayout;
    }

    */
}
