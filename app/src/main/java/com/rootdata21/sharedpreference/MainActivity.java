package com.rootdata21.sharedpreference;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button showData, saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        showData = findViewById(R.id.buttonShow);
        saveData = findViewById(R.id.storeinformation);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id){
                    case R.id.buttonShow:
                        displayText();
                        break;
                    case R.id.storeinformation:
                        Intent intent = new Intent(MainActivity.this, PreferenceScreen.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        };

        showData.setOnClickListener(onClickListener);
        saveData.setOnClickListener(onClickListener);
    }

    private void displayText() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = sharedPreferences.getString("username","");
        String age = sharedPreferences.getString("age","");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Username : "+username+"\n");
        stringBuilder.append("Age : "+age+"\n");
        textView.setText(stringBuilder);
    }


}