package com.rohan.rapidemos.activity.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rohan.rapidemos.R;
import com.rohan.rapidemos.utils.Logger;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Logger.logError("inside second A");
    }
}
