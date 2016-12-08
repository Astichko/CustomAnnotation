package com.example.boss.customannotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Default
    private String text;
    @Default
    public int number;
    @Default
    protected float decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dagger.inject(this);
    }

    public void showValues(View view) {
        Toast.makeText(this, text + " - " + decimal + " - " + number, Toast.LENGTH_LONG).show();
        Log.v("myLogs", text + " - " + decimal + " - " + number);
    }
}
