package com.example.ankhleu.trackingyourspendingv3.tripdata;

/**
 * Created by ankhleu on 2018/1/31.
 */

public class trip_constructor {

    //這邊放有活動中的建構式

    //public int id; //活動id
    public static int id; //活動id

    public String title; // 標題
    public String startdate;// 旅遊開始時間
    public String enddate;//   旅遊結束時間
    public int budget; //預算


    public trip_constructor(String title,String startdate,String enddate,int budget)
    {
       // this.id = id ;
        this.title = title ;
        this.startdate = startdate ;
        this.enddate=enddate ;
        this.budget=budget;

    }
}
