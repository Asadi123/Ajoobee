package com.ajoobee.mm.Data.Obj;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public String id;

    public String token;

    public User(String token) {
        this.token = token;
    }
}
