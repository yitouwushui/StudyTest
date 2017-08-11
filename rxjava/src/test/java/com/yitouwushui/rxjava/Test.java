package com.yitouwushui.rxjava;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by yitouwushui on 2017/5/19.
 */

public class Test {

    private static final String tag = "rxJava";


    public static void main(String[] args) {

    }

    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        }
    });

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
