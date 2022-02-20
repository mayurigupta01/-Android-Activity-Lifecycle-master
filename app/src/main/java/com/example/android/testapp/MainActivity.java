package com.example.android.testapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button dialogue;
    TextView info;
    TextView thread;
    private static int threadCount ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener((view)-> { exitApp();});
        dialogue = (Button) findViewById(R.id.button3);
        dialogue.setOnClickListener((view)->{showDialogue();});
        thread = (TextView) findViewById(R.id.textView3);
        thread.setText(String.format("Thread count: %d",threadCount));
        Log.e("onCreate ------ ", "MainActivity: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart ------ ","MainActivity: onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        thread.setText(String.format("Thread count: %d",threadCount++));
        Log.e("onResume ------ ","MainActivity: onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause ------ ","MainActivity: onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop ------ ","MainActivity: onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy ------ ","MainActivity: onDestroy()");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        thread.setText(String.format("Thread count: %d",threadCount++));
        Log.e("onRestart ------ ","MainActivity: onRestart()");

    }

    public void switchActivity(View view){
        Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
        startActivity(intent);

    }

    public void exitApp(){
        finish();
        System.exit(0);
    }

    public void showDialogue(){
        thread.setText(String.format("Thread count: %d",threadCount++));
        Dialog dialog = new Dialog(MainActivity.this);
        info= (TextView) findViewById(R.id.textView2);
        dialog.setCancelable(true);
        String name = "This is my first App";
        PopulateName(name);
        dialog.show();

    }
    public void PopulateName(String name){
     info.setVisibility(View.VISIBLE);
     info.setText(name);
    }
}
