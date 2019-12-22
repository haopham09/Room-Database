package com.thohao.roomdatabase;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM Students")
    Observable<List<Students>>getAllStudents();
}
