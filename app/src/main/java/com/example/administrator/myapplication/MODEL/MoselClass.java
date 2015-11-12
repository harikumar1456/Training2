package com.example.administrator.myapplication.MODEL;

import java.util.List;

/**
 * Created by Administrator on 11/6/2015.
 */
public class MoselClass {
   // public String title;
//    public List<Dataset> results;
//    public String place_id;
//    public String id;
    public List<Results> results;

    public class Results
    {
        public String name;
        public String icon;
       // public List<Photos> photos;
       public List<Photos> photos;
        public class Photos
        {
            public String photo_reference;
        }

    }


}
