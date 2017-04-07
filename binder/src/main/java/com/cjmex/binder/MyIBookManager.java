//package com.cjmex.binder;
//
//import android.os.IBinder;
//import android.os.IInterface;
//
///**
// * Created by ding on 2017/3/9.
// */
//
//public interface MyIBookManager extends IInterface {
//
//    static final String DESCRIPTOR = "com.cjmex.binder.MyIBookManager";
//
//    static final int TRANSACTION_getBookList = (IBinder.FIRST_CALL_TRANSACTION + 0);
//    static final int TRANSACTION_addBook = (IBinder.FIRST_CALL_TRANSACTION + 1);
//
//    /**
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    public java.util.List<Book> getBookList() throws android.os.RemoteException;
//
//    public void addBook(Book book) throws android.os.RemoteException;
//}
