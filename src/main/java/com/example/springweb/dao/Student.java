package com.example.springweb.dao;

import java.io.Serializable;

/**
 * @author 学生的基本数据结构
 */
public class Student implements Serializable {
    private String id;
    //学号

    private String name;
    //姓名

    private String sex;
    //性别

    private String birth;
    //出生日期

    private String nativePlace;
    //籍贯

    private String department;
    //学院

    public Student()
    {
        id = null;
        name = null;
        sex = null;
        birth = null;
        nativePlace = null;
        department = null;
    }

    public  Student(String id, String name, String sex, String birth, String nativePlace, String department)
    {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.nativePlace = nativePlace;
        this.department = department;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return id+","+name+","+sex+","+birth+","+nativePlace+","+department;
    }
}
