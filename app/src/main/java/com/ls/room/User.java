package com.ls.room;

/**
 * Created on 03/01/2018.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String email;
    public String createdAt;

    public User(String name, String email, String createdAt) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }
}
