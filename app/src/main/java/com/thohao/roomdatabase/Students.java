package com.thohao.roomdatabase;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//chỉ đinh class một table trong database qua Entity
@Entity
public class Students {
    //set primary key cho id, và auto tăng giá trị
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String name;
    private Integer age;
    private String address;

    //Ignore chỉ sử dung cho giao dien
    @Ignore
    public Students() {
    }

    public Students(@NonNull String name, @NonNull Integer age, @NonNull String address) {


        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
