package com.example.lifecycleapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ACT1 = "Activity1";
    public static final int QUOTE_REQUEST_CODE = 382;
    private TextView textQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ACT1, "on create() function called");
        textQuote = findViewById(R.id.textQuote);
        Button btnGet = findViewById(R.id.btn);
        btnGet.setOnClickListener(view -> {
            Intent i = new Intent(this, QuoteActivity.class);
            startActivityForResult(i, QUOTE_REQUEST_CODE);
        });
        Log.d(ACT1, "ui code generated");
        if (savedInstanceState!=null){
            String quoteValue = savedInstanceState.getString("quoteValue");
            textQuote.setText(quoteValue);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == QUOTE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                double quote = data.getDoubleExtra("quote", 0.00);
                textQuote.setText(String.valueOf(quote));
            } else if (resultCode == RESULT_CANCELED) {
                textQuote.setText("No Quote");
                textQuote.setTextColor(Color.RED);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(ACT1, "on saveInstaceState() called");
        String value = textQuote.getText().toString();
        outState.putString("quoteValue",value);
    }


    @Override
    protected void onStart() {
        Log.d(ACT1, "on start() function called");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(ACT1, "on resume() function called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(ACT1, "on pause() function called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(ACT1, "on stop() function called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(ACT1, "on destroy() function called");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(ACT1, "on restart() function called");
        super.onRestart();
    }


}