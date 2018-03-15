package com.yitouwushui.rxjava;

import java.util.List;

/**
 * Created by yitouwushui on 2018/3/15.
 */

public class Student {

    public Student() {
    }

    public Student(String name, List<Course> coursesList) {
        this.name = name;
        this.coursesList = coursesList;
    }

    private String name;//姓名
    private List<Course> coursesList;//所修的课程

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }
}
