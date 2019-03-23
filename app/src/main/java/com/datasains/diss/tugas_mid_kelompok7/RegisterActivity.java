package com.datasains.diss.tugas_mid_kelompok7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class RegisterActivity extends AppCompatActivity {
    Realm realm;

    RealmResults<UserModel> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        realm = Realm.getDefaultInstance();
    }

    public void register(View view) {
        String phone = ((TextView)findViewById(R.id.phone)).getText().toString();
        String name = ((TextView)findViewById(R.id.name)).getText().toString();
        String password = ((TextView)findViewById(R.id.password)).getText().toString();
        UserModel model = new UserModel(phone, name, password);
        Toast.makeText(this, "berhasil"+phone+name+password, Toast.LENGTH_LONG).show();

        realm.beginTransaction();
        realm.copyToRealm(model);
        realm.commitTransaction();
    }

    public void cek(View view) {
        user = realm.where(UserModel.class).findAll();
        String size = String.valueOf(user.size());
        Toast.makeText(this, size, Toast.LENGTH_LONG).show();
    }
}
