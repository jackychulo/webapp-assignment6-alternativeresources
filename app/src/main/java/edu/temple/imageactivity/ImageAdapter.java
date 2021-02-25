package edu.temple.imageactivity;

import android.content.Context;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    ArrayList<Integer> imageitems;

    public ImageAdapter (Context context, ArrayList items, ArrayList imageitems){
        this.context = context;
        this.items = items;
        this.imageitems = imageitems;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        Pair<String, Integer> cat = new Pair(items.get(position), imageitems.get(position));
        return cat;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView cattextview;
        ImageView imageitemstextview;
        LinearLayout linearlayout;
        if(convertView == null){
            linearlayout = new LinearLayout(context);
            linearlayout.setOrientation(LinearLayout.VERTICAL);
            linearlayout.setGravity(Gravity.CENTER_HORIZONTAL);
            cattextview = new TextView(context);
            cattextview.setTextSize(35); //text size
            imageitemstextview = new ImageView(context);

            linearlayout.addView(cattextview);
            linearlayout.addView(imageitemstextview);
        }else{
            linearlayout = (LinearLayout) convertView;
            cattextview = (TextView) linearlayout.getChildAt(0);
            imageitemstextview = (ImageView) linearlayout.getChildAt(1);
        }
        //////////////
        // name     //
        // surname  //
        cattextview.setText(items.get(position)); //name
        cattextview.setGravity(Gravity.CENTER); //set textview center
        imageitemstextview.setImageResource(imageitems.get(position)); //surname
        imageitemstextview.getLayoutParams().height = 250; //set image size
        imageitemstextview.getLayoutParams().width = 250; //set image size

        return linearlayout;
    }
}
