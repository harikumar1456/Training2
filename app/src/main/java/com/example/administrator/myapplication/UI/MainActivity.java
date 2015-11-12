package com.example.administrator.myapplication.UI;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.myapplication.API.ApiClass;
import com.example.administrator.myapplication.MODEL.Curators;
import com.example.administrator.myapplication.MODEL.MoselClass;
import com.example.administrator.myapplication.R;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    public String base_Url="http://freemusicarchive.org/api";
    public String Url="https://maps.googleapis.com/maps/api";
    EditText textView;
    Button searchButton;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(EditText)findViewById(R.id.searchEditText);
        searchButton=(Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String search =textView.getText().toString();
                boolean f=validationFunction(search);
//                if(f) {
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    search = search.toLowerCase();
                    intent.putExtra("search", search);
                    startActivity(intent);
//                }
            }
        });
        
//

    }

    public boolean validationFunction(String search) {
        boolean f1=false;
        switch (search)
        {
            case  "accounting":
                f1= true;break;
            case "airport":f1= true;break;
            case"aquarium" : f1=  true;break;
            case" art_gallery" : f1=  true;break;
            case"atm" : f1=  true;break;
            case" bakery" : f1= true;break;
            case"   bank" : f1=  true;break;
            case"  bar" : f1=  true;break;
            case"beauty_salon" : f1=  true;break;
            case" book_store" : f1=  true;break;
            case" bowling_alley" : f1=  true;break;
            case"bus_station" : f1=  true;break;
            case"cafe" : f1= true;break;
            case"amusement_park" : f1=  true;break;






        }
       return f1;
    }

}
