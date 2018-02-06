package com.example.ankhleu.trackingyourspendingv3.tripdata;

/**
 * Created by ankhleu on 2018/1/31.
 */

public class tripadd_constructor {

    int id;
    String date;        //日期
    int money;          //金額
    String subject;     //項目
    String currency;    //幣別
    String note;        //註記

    public tripadd_constructor(String date,int money,String subject,String currency,String note)
    {
        this.id = id ;
        this.date = date;
        this.money = money;
        this.subject = subject;
        this.currency = currency;
        this.note = note;
    }
}
