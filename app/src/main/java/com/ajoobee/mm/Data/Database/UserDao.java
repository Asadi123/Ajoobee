package com.ajoobee.mm.Data.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import com.ajoobee.mm.Data.Obj.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User user);

    @Query("SELECT * FROM User WHERE token = :value")
    public Cursor checkUserExist(String value);

}
