package com.example.administrator.myapplication.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 11/9/2015.
 */
public class List extends BaseAdapter {
        LayoutInflater layoutInflater;
        String array[],icon[];
        ImageView imageView;
        TextView textView;
        ListActivity activity;
        String url="https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CmRdAAAALYLLVSDqhbhHESif7Imr4B7kDsfuf34OzkkG74Lbpop3Reg40R5LR0dfz08t5r2PtkCidlSo8V0Floj3gTlfNfqoYt_uFH581xsfY4SCiu46IGQ_e11PCOtWgMHsMfMUEhDcW0xY14UaSD2I9Lf25SuRGhRGqtux9E4GTkhKF_TxurGxN-tHpg&key=AIzaSyD1r76tid2LU4RodDNSgTWSjHQLRXmK5Zo";

    List(ListActivity activity,String array[] ,String icon[])
        {   this.activity=activity;
            this.array=array;
            this.icon=icon;
            layoutInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        System.out.println("length"+array.length);
        return array.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView=layoutInflater.inflate(R.layout.activity_list,null);
       textView=(TextView)convertView.findViewById(R.id.textView);
        textView.setText(array[position]);
        System.out.println(icon[position] + "pppp" + position);
        imageView=(ImageView)convertView.findViewById(R.id.imageView);
        String p=icon[position];
//
        Picasso.with(activity).load(url).resize(80,80).into(imageView);
        return convertView;
    }
}
