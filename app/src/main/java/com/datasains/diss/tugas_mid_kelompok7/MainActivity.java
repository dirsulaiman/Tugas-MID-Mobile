package com.datasains.diss.tugas_mid_kelompok7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);

        realm = Realm.getDefaultInstance();

    }

    public void loginButton(View view) {
//        Intent intent = new Intent(this, TugasDialogActivity.class);
//        startActivity(intent);
//        this.finish();

        String phone = ((TextView)findViewById(R.id.phone)).getText().toString();
        String password = ((TextView)findViewById(R.id.password)).getText().toString();

        UserModel user = realm.where(UserModel.class).equalTo("id", phone).findFirst();
        Toast.makeText(this, user.getName(),Toast.LENGTH_LONG).show();

//        realm.beginTransaction();
//        user.deleteAllFromRealm();
//        realm.commitTransaction();
    }

    public void registerPage(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        //this.finish();
    }
}
