package com.example.ankhleu.trackingyourspendingv3;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ankhleu.trackingyourspendingv3.tripdata.trip_constructor;

import java.util.Calendar;

public class Newstart extends AppCompatActivity {

    EditText ed, ed2;
    TextView str, end, bud;
    private int mYear, mMonth, mDay; //時間單位
    public String[][] data={{"1","id","startdate","endate","budget"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newstart);
        str = findViewById(R.id.startday);
        end = findViewById(R.id.endday);
    }

    public void startime(View v) {
        showDatePickerDialog();  //執行選時間
    }

    public void endtime(View v) {
        showDatePickerDialog2();
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
                        str.setText(year + "-" + (monthOfYear + 1) + "-"
                                + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void showDatePickerDialog2() {
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
                        end.setText(year + "-" + (monthOfYear + 1) + "-"
                                + dayOfMonth); //這邊設給結束時間

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void CL1(View v) {

        ed = findViewById(R.id.editText2);
       // ed2 = findViewById(R.id.editText);
        str = findViewById(R.id.startday);
        end = findViewById(R.id.endday);
        bud = findViewById(R.id.editText9);

        String title = ed.getText().toString();
       // int id = Integer.valueOf(ed2.getText().toString());
        String startdate = str.getText().toString();//抓選好後的開始時間
        String enddate = end.getText().toString(); //抓選好後的結束時間
        int budget = Integer.valueOf(bud.getText().toString()); //抓填入的預算金額

        MainActivity.dao.add(new trip_constructor(title, startdate, enddate, budget));

        ListView listView = (ListView) findViewById(R.id.listview);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewAdapter adapter = new ViewAdapter(data, inflater);
        adapter.notifyDataSetChanged();

        finish();
    }
}
