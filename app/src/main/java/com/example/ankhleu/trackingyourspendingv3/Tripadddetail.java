package com.example.ankhleu.trackingyourspendingv3;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.ankhleu.trackingyourspendingv3.tripdata.tripadd_constructor;



public class Tripadddetail extends AppCompatActivity {

    TextView tv1 ; //時間
    EditText ed1,ed2; //金額 註記
    Spinner sp1,sp2; //項目 幣別
    private int mYear, mMonth, mDay;//時間單位
    public static String time ;
    public int money;
    public String note;
    public String subject;
    public String Currency;
    ImageButton ib;
    ImageView iv;
    public Context context;


    public String[][] data={{"1","time","subject","money","note"}};


    public void time(String time)
    {
        this.time=time;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tripadddetail);

        context=this;
        tv1 = findViewById(R.id.textView);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        String dts = sdf.format(dt);
        tv1.setText(dts);  //預設是顯示當下時間

        sp1 = findViewById(R.id.pick);
        ArrayAdapter<CharSequence> objList = ArrayAdapter.createFromResource(this,
                R.array.subject,android.R.layout.simple_list_item_1);
        sp1.setAdapter(objList); //把值帶入

        sp2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> curList = ArrayAdapter.createFromResource(this,
                R.array.currency,android.R.layout.simple_list_item_1);
        sp2.setAdapter(curList);
        iv=(ImageView)findViewById(R.id.imageView);




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100)
        {
            if (requestCode==RESULT_OK)
            {
                File f=new File(getExternalFilesDir("PHOTO"),"myphoto.jpg");
                Uri photouri=FileProvider.getUriForFile(this,
                this.getApplicationContext().getPackageName()+".my.package.name.provider",f);
                try {
                    InputStream is=getContentResolver().openInputStream(photouri);
                    Log.d("BMP","Can READ:"+is.available());
                    Bitmap bmp=getFitImage(is);
                    iv.setImageBitmap(bmp);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Bitmap getFitImage(InputStream is) {

        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=false;
        byte[] bytes=new byte[0];
        try {
        bytes=readStream(is);
        //BitmapFactory.decodeStream(inputStream,null,options);
        Log.d("BMP","byte length:"+bytes.length);
        Bitmap bmp=BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);
        System.gc();
        return bmp;

            }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private static byte[] readStream(InputStream inStream)throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        inStream.close();
        return outputStream.toByteArray();

    }

    public void takephoto(View v)
    {


        Intent it=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f=new File(getExternalFilesDir("PHOTO"),"myphto.jpg");
        Uri photouri= FileProvider.getUriForFile(this,
                this.getApplicationContext().getPackageName() +".my.package.name.provider",f);
        it.putExtra(MediaStore.EXTRA_OUTPUT, photouri);
        startActivityForResult(it,100);


    }




    public void clicktime(View v) //改時間
    {
        showDatePickerDialog();
    }
    public void showDatePickerDialog() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 完成選擇，顯示日期
                        tv1.setText(year + "-" + (monthOfYear + 1) + "-"
                                + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();


    }



    public void clickgo(View v) {
        ed1 = findViewById(R.id.editText7);
        ed2 = findViewById(R.id.editText3);
        tv1 = findViewById(R.id.textView);
        sp1 = findViewById(R.id.pick);
        sp2 = findViewById(R.id.spinner2);


//        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {  //監聽他選了哪個
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        money = Integer.valueOf(ed1.getText().toString());
        note = ed2.getText().toString();
        //String time = tv1.getText().toString();  //抓時間很奇怪
        time = tv1.getText().toString();  //抓時間很奇怪
        subject = sp1.getSelectedItem().toString();
        Currency = sp2.getSelectedItem().toString();

        MainActivity.dao2.add(new tripadd_constructor(1,time, money, subject, Currency, note));


        ListView listView = (ListView) findViewById(R.id.listview);


        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewAdapter adapter = new ViewAdapter(data, inflater);
        adapter.notifyDataSetChanged();
//        listView.setAdapter(adapter);
//        finish();

//    }
   if (listView != null) {    //老師這裡下if listview=null,執行adapter
        listView.setAdapter(adapter);
    }



        finish();
    }


    public void clickno(View v)
    {
        finish();
    }


}


