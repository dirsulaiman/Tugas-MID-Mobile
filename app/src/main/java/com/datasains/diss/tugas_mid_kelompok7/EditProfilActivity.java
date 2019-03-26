package com.datasains.diss.tugas_mid_kelompok7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.exceptions.RealmMigrationNeededException;

public class EditProfilActivity extends AppCompatActivity {
    String id;
    String name;
    String password;
    String address;
    String ttl_place, ttl_date, ttl_month, ttl_year;
    String religion;
    String email;
    boolean isMale;
    EditText editText_name, editText_address, editText_birthday, editText_religion, editText_email, editText_gender, editText_password;
    TextView editText_phone;
    Realm realm;
    UserModel user;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        try {
            realm = Realm.getDefaultInstance();
        } catch (RealmMigrationNeededException r) {
            Realm.deleteRealm(realm.getDefaultConfiguration());
            realm = Realm.getDefaultInstance();
        }
        
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
        }

        editText_name = findViewById(R.id.edit_name);
        editText_phone = findViewById(R.id.edit_phone);
        editText_password = findViewById(R.id.edit_password);
        editText_address = findViewById(R.id.edit_address);
        editText_religion = findViewById(R.id.edit_religion);
        editText_email = findViewById(R.id.edit_email);
        editText_birthday = findViewById(R.id.edit_birthday);
        editText_gender = findViewById(R.id.edit_gender);

        user = realm.where(UserModel.class).equalTo("id", id).findFirst();
        if (user != null) {
            name = user.getName();
            password = user.getPassword();
            isMale = user.getGender();
            address = user.getAddress();
            religion = user.getReligion();
            ttl_place = user.getTtl_place();
            ttl_date = user.getTtl_date();
            ttl_month = user.getTtl_month();
            ttl_year = user.getTtl_year();
            email = user.getEmail();
            String gender = isMale ? "Pria" : "Wanita";

            editText_name.setText(name);
            editText_phone.setText("+62"+id);
            editText_password.setText(password);
            editText_address.setText(address);
            editText_religion.setText(religion);
            editText_email.setText(email);
            editText_birthday.setText(ttl_place+" "+ttl_date+" "+ttl_month+" "+ttl_year);
            editText_gender.setText(gender);
        }

    }

    public void saveProfile(View view) {
        user = realm.where(UserModel.class).equalTo("id", id).findFirst();
        if (user != null) {
            name = editText_name.getText().toString();
            password = editText_password.getText().toString();
//            isMale = editText_gender.getText().toString();
            address = editText_address.getText().toString();
            religion = editText_religion.getText().toString();
//            ttl_place = user.getTtl_place();
//            ttl_date = user.getTtl_date();
//            ttl_month = user.getTel_month();
//            ttl_year = user.getTtl_year();
            email = editText_email.getText().toString();

            realm.beginTransaction();
            user.setName(name);
            user.setPassword(password);
            user.setGender(false);
            user.setAddress(address);
            user.setReligion(religion);
            user.setTtl_month(ttl_month);
            user.setTtl_date(ttl_date);
            user.setTtl_place(ttl_place);
            user.setTtl_year(ttl_year);
            user.setEmail(email);
            realm.commitTransaction();
        }

        Intent intent = new Intent(this, ProfilViewActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
        this.finish();
    }
}
