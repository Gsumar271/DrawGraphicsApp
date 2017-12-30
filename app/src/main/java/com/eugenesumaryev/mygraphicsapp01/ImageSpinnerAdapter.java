package com.eugenesumaryev.mygraphicsapp01;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eugenesumaryev on 12/27/17.
 */

public class ImageSpinnerAdapter extends ArrayAdapter<String> {

    LayoutInflater inflater;
    int res;
    ArrayList<BrushItem> list;


    /*
    public ImageSpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource);

        res = resource;
    }*/

    public ImageSpinnerAdapter(Context context, int resource, ArrayList list) {
        super(context, resource, list);

        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res=resource;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //LinearLayout circleView;
        //ViewHolder brushViewHolder;

        View itemView=inflater.inflate(res,parent,false);
        /*
        ImageView imageView=(ImageView)itemView.findViewById(R.id.spinner_image);
       // imageView.setImageResource(list.get(position).getImageId());
        imageView.setImageDrawable(getContext().getResources()
                .getDrawable(R.drawable.medium_circle));
                */
        Resources resources = getContext().getResources();

        TextView textView = (TextView)itemView.findViewById(R.id.spinner_text);
       // textView.setText(list.get(position).getSomeText());

       // Log.v("text", list.get(position).getSomeText());

        ImageView companyLogo = (ImageView)itemView.findViewById(R.id.spinner_image);

        Drawable circleImg = resources.getDrawable(R.drawable.medium_circle);

        switch(position) {
            case 0:
                circleImg = resources.getDrawable(R.drawable.large_circle);
                break;
            case 1:
                circleImg = resources.getDrawable(R.drawable.medium_circle);
                break;
            case 2:
                circleImg = resources.getDrawable(R.drawable.small_circle);
                break;
            default:
                break;
        }


        companyLogo.setImageDrawable(circleImg);


        /*
        if (convertView == null) {
           // itemView = getLayoutInflater().inflate(resource, todoView, true);

            circleView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater)getContext().getSystemService(inflater);
            li.inflate(R.layout.circles_spinner_layout, parent, false);
        } else {
            circleView = (LinearLayout) convertView;
        }


        ImageView circle = (ImageView) circleView.findViewById(R.id.spinner_image);
        Resources res = getContext().getResources();

        int[] allCircles = res.getIntArray(R.array.circles);

        Drawable circleImg = res.getDrawable(allCircles[position]);

        circle.setImageDrawable(circleImg);


        return circleView;
        */

        return itemView;
    }


    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
