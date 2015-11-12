package com.example.administrator.myapplication.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myapplication.API.ApiClass;
import com.example.administrator.myapplication.MODEL.MoselClass;

import com.example.administrator.myapplication.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListActivity extends AppCompatActivity {
    TextView textView;


    //public String Url="https://maps.googleapis.com/maps/api";
    public String Url="https://maps.googleapis.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        textView=(TextView)findViewById(R.id.textView);
        Intent intent=getIntent();
        String Search=intent.getStringExtra("search");
        System.out.println("hhhhhh1"+Search);
        Search=Search.trim();
        ApiFunction(Search);

    }
    public void ApiFunction(String Search)
    {

        final RestAdapter rest=new RestAdapter.Builder().setEndpoint(Url).build();
        final ApiClass apiClass=rest.create(ApiClass.class);
        final Callback callback=new Callback() {
            ListView list=(ListView)findViewById(R.id.listView);
            String[] hotelList;//=new String[100];
            String [] icon;//=new  String[100];
            String [] photo;
            int i=0,j=0;
            @Override
            public void success(Object o, Response response) {
                System.out.println("hai");


                MoselClass model = (MoselClass) o;

                System.out.println("oo"+o.toString());

//               MoselClass.results data= (MoselClass.results) model.results.get(1);
//              System.out.println("hhhh"+data.name);

                for (MoselClass.Results result : model.results) {

                    //textView.setText(textView.getText()+result.name+"\n");
                    i=i+1;
                }
                hotelList=new String[i];
                icon=new String[i];
                photo=new String[i];
                i=0;
                for (MoselClass.Results result : model.results) {
                    hotelList[i]=result.name;
                    icon[i]= result.icon;

                    i=i+1;
                }


//                for(MoselClass.Results results:model.results)
//                {
//                    for(Photos photos:results.photos)
//                    {
//                        System.out.println(photos.photo_reference);
//                    }
//
//                }

//               for(MoselClass.Results result1 : model.results)
//                {
//                   System.out.print("hh"+result1.photos);
//
//                   for(MoselClass.Results.Photos photos : result1.photos)
//                    {
//                        photo[j] = photos.photo_reference;
//                        System.out.print(photo[j]);
//                        photo[j]=photos.width;
//                        j = j + 1;
//
//                    }
//
//                }



               // System.out.println(photo[0]+"reference");
                list.setAdapter(new List(ListActivity.this,hotelList,icon));

            }
            @Override
            public void failure(RetrofitError error) {
            textView.setText("Error");
            }
        };
        apiClass.getCurators("8.5656,76.8747", "500", Search,"AIzaSyD1r76tid2LU4RodDNSgTWSjHQLRXmK5Zo", callback);

    }

}
