package com.thohao.roomdatabase;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel implements LifecycleObserver {
    private CompositeDisposable disposable =new CompositeDisposable();
    private MutableLiveData<List<Students>> listStudents = new MutableLiveData<>();
    @SuppressLint("CheckResult")
    public LiveData<List<Students>> getListStudents(Context context) {
        DatabaseRepository
                .getInstance(context)
                .getAllStudents()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Students>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<Students> students) {
                        listStudents.setValue(students);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return listStudents;
    }

    public void disableListenData() {
        disposable.clear();
    }
}
