package com.example.ankhleu.trackingyourspendingv3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ankhleu on 2018/2/12.
 */

public class PhotoActivity extends Tripadddetail {


    public TextView tv;
    public ImageView iv;

    @Override
    public void onCreate(Bundle savedInstanceState,PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        tv=(TextView)findViewById(R.id.textView4);
        tv.setText(Tripadddetail.time.substring(4,12));
    }
}
