package com.datasains.diss.tugas_mid_kelompok7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginButton(View view) {
//        Intent intent = new Intent(this, TugasDialogActivity.class);
//        startActivity(intent);
//        this.finish();
    }

    public void registerButton(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        this.finish();
    }
}
