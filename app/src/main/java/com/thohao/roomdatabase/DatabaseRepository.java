package com.thohao.roomdatabase;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;

public class DatabaseRepository {
    private StudentDao studentDao;
    private static DatabaseRepository databaseRepository;

    private DatabaseRepository(Context context) {

        StudentDatabase studentDatabase = StudentDatabase.getInstance(context);
        studentDao = studentDatabase.studentDao();
    }

    public static DatabaseRepository getInstance(Context context) {
        if (databaseRepository == null) {
            databaseRepository = new DatabaseRepository(context);
        }
        return databaseRepository;
    }

    public Observable<List<Students>> getAllStudents() {

        return studentDao.getAllStudents();
    }
}
