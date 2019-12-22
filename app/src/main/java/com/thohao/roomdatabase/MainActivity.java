package com.thohao.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new MainViewModel();
        getLifecycle().addObserver(mainViewModel);
        mainViewModel.getListStudents(this).observe(this, new Observer<List<Students>>() {
            @Override
            public void onChanged(List<Students> students) {
                if (students != null) {
                    Log.d("BBB", students.size()+"");
                }
            }
        });

    }
}
