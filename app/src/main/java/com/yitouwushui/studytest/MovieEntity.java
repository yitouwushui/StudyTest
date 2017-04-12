package com.yitouwushui.studytest;

import java.util.List;

/**
 * Created by ding on 2017/2/17.
 */

public class MovieEntity {

    int count;
    int start;
    int total;
    List<Movie> subjects;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Movie> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Movie> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", subjects=" + subjects +
                '}';
    }
}
