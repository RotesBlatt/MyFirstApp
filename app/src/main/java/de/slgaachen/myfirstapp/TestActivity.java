package de.slgaachen.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "de.slgaachen.myfirstapp.MESSAGE";
    TextView textView;
    String message;
    //String surprise;
    TextView switch_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = findViewById(R.id.activity2Output_TextView);
        switch_textView = findViewById(R.id.switch_TextView);

       retrieveIntent();

    }

    public void newActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onSwitch(View view){
        if(switch_textView.getVisibility() == View.VISIBLE)
            switch_textView.setVisibility(View.INVISIBLE);
        else {
            switch_textView.setVisibility(View.VISIBLE);
            switch_textView.setText(R.string.onVisible_text);
        }
    }

    public void retrieveIntent(){
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if(!(message.isEmpty()))
            textView.setText(message);
        else
            textView.setText(R.string.noInput_text);
    }
}