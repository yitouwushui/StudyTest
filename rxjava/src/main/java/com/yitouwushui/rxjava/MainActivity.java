package com.yitouwushui.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "rxJava";
    private static final String TAG = "rxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        observable.subscribe(observer);

//        Observable<String> observable = Observable.just("Hello", "Hi", "Aloha");
//
//        observable.subscribe(observer);

//        testRx();
        testRx2();

    }

    private void testRx2() {
        List<Course> courseList = new ArrayList<Course>();
        courseList.add(new Course("语文","1"));
        courseList.add(new Course("数学","2"));
        courseList.add(new Course("英语","3"));

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("A",courseList));
        courseList.add(new Course("体育","4"));
        //ff
        students.add(new Student("B",courseList));
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        Log.i(TAG, student.getName());
                        return Observable.from(student.getCoursesList());
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        Log.i(TAG, course.getName());
                    }
                });

    }

    private void testRx() {
        List<Course> courseList = new ArrayList<Course>();
        courseList.add(new Course("语文","1"));
        courseList.add(new Course("数学","2"));
        courseList.add(new Course("英语","3"));

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("A",courseList));
        courseList.add(new Course("体育","4"));

        students.add(new Student("B",courseList));

        Action1<List<Course>> action1 = new Action1<List<Course>>() {
            @Override
            public void call(List<Course> courses) {
                //遍历courses，输出cuouses的name
                for (int i = 0; i < courses.size(); i++){
                    Log.i(TAG, courses.get(i).getName());
                }
            }
        };
        Observable.from(students)
                .map(new Func1<Student, List<Course>>() {
                    @Override
                    public List<Course> call(Student student) {
                        //返回coursesList
                        Log.i(TAG, student.getName());
                        return student.getCoursesList();
                    }
                })
                .subscribe(action1);
    }

//    Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//        @Override
//        public void call(Subscriber<? super String> subscriber) {
//            subscriber.onNext("Hello");
//            subscriber.onNext("Hi");
//            subscriber.onNext("Aloha");
//            subscriber.onCompleted();
//        }
//    });

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onNext(String s) {
            Log.d(tag, "Item: " + s);
        }

        @Override
        public void onCompleted() {
            Log.d(tag, "Completed!");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(tag, "Error!");
        }
    };
}
