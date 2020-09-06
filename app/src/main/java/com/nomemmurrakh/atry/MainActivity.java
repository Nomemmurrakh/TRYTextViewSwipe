package com.nomemmurrakh.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwipeAbleTextView textView;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.swipeAbleTextView);
        textView.setCallback(new SwipeAbleTextView.Callback() {
            @Override
            public void onReceive(String text) {
                Toast.makeText(context, text, Toast.LENGTH_LONG).show();
            }
        });
    }
}