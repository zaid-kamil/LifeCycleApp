package com.example.lifecycleapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuoteActivity extends AppCompatActivity {

    public static final String ACT2 = "activity 2";
    private int number = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        Log.d(ACT2, "on create() called");
        Button btnDone = findViewById(R.id.btnDone);
        TextView textGen = findViewById(R.id.textGenerate);
        textGen.setOnClickListener(view -> {
            Random random = new Random();
            number = random.nextInt(10000);
            Toast.makeText(this, "quote generated", Toast.LENGTH_SHORT).show();
        });
        btnDone.setOnClickListener(view -> {
            if (number > -1) {
                Intent data = new Intent();
                data.putExtra("quote", Double.valueOf(number));
                setResult(RESULT_OK, data);
            } else {
                setResult(RESULT_CANCELED);
            }
            finish();
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(ACT2, "on saveInstaceState() called");
    }


    @Override
    protected void onStart() {
        Log.d(ACT2, "on start() function called");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(ACT2, "on resume() function called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(ACT2, "on pause() function called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(ACT2, "on stop() function called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(ACT2, "on destroy() function called");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(ACT2, "on restart() function called");
        super.onRestart();
    }

}