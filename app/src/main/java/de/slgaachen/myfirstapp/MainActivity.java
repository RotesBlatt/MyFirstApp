package de.slgaachen.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "de.slgaachen.myfirstapp.MESSAGE";

    TextView tv1;
    TextView tv2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.welcome_TextView);
        tv2 = findViewById(R.id.output_TextView);
        editText = findViewById(R.id.input_PlainText);

        Log.v(EXTRA_MESSAGE, "HALlöle");

        //onlyEveryTwo();
    }

    public void onlyEveryTwo() {
        tv2.setText("");
        for (int i = 0; i < tv1.length(); i += 2) {
            char testCh = tv1.getText().charAt(i);
            tv2.append(String.valueOf(testCh));
        }
    }

    public void newActivity(View view){
        Intent intent = new Intent(this, TestActivity.class);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void insertText(View view) {
        if (!(TextUtils.isEmpty(editText.getText()))) {
            tv2.setText(editText.getText());
        } else {
            tv2.setText(R.string.output_text);
        }
    }
}