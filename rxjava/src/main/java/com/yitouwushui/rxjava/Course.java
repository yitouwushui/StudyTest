package com.yitouwushui.rxjava;

/**
 * Created by yitouwushui on 2018/3/15.
 */

public class Course {

    public Course(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;//课程名
    private String id;
}
