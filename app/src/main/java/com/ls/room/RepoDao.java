package com.ls.room;

/**
 * Created on 03/01/2018.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RepoDao {
    @Query("SELECT * FROM User")
    List<User> getAllRepos();

    @Insert
    void insert(User... users);

    @Query("UPDATE User SET email = :newEmail")
    void updateEmail(String newEmail);

    @Query("DELETE FROM User WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE User SET email = :newEmail WHERE id = 2")
    void updateById(String newEmail);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);
}
