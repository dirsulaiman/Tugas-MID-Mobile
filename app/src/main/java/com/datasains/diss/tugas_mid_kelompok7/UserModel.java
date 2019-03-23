package com.datasains.diss.tugas_mid_kelompok7;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class UserModel extends RealmObject {
    @Required
    @PrimaryKey
    private String id;  //no.hp
    @Required
    private String name;
    @Required
    private String password;
    private boolean isMale;
    //attributes

    public UserModel () {}

    public UserModel (String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId () {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPassword () {
        return this.password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public boolean getGender () {
        return this.isMale;
    }

    public void setGender (boolean isMale) {
        this.isMale = isMale;
    }
}
