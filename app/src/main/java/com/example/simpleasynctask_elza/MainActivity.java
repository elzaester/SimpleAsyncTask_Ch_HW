package com.example.simpleasynctask_elza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextview;
    private static final String TEXT_STATE = "currentText";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextview = findViewById(R.id.textView1);

        if(savedInstanceState != null){
            mTextview.setText(savedInstanceState.getString(TEXT_STATE));
        }

    }

    public void startTask(View view) {
        mTextview.setText(R.string.napping);
        new SimpleAsyncTask(mTextview).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, mTextview.getText().toString());
    }
}
