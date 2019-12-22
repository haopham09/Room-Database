package com.thohao.roomdatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Students.class},version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase studentDatabase=null;

    protected abstract StudentDao studentDao();

    public static synchronized StudentDatabase getInstance(Context context) {
        if (studentDatabase == null) {
            studentDatabase = Room.databaseBuilder(
                    context,
                    StudentDatabase.class,
                    "StudentManagement")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return studentDatabase;
    }
}
