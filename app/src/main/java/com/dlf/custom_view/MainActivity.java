package com.dlf.custom_view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DeleteView mDeleteLine;
    private SpinnerView mSpinnerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDeleteLine = (DeleteView) findViewById(R.id.deleteLine);
        mSpinnerView = (SpinnerView) findViewById(R.id.spinnerView);
        mDeleteLine.setDeleteLine();
    }
}
