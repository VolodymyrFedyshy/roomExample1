package com.ls.room;

/**
 * Created on 03/01/2018.
 */

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;


@Database(entities = { User.class }, version = 2)
public abstract class RepoDatabase extends RoomDatabase {

    private static final String DB_NAME = "repoDatabase.db";
    private static volatile RepoDatabase instance;

    public static synchronized RepoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static RepoDatabase create(final Context context) {
        return Room
                .databaseBuilder(context, RepoDatabase.class, DB_NAME)
                .addMigrations(FROM_1_TO_2)
                .build();
    }

    static final Migration FROM_1_TO_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE User ADD COLUMN createdAt TEXT");
        }
    };

    public abstract RepoDao getRepoDao();

}
