package com.cjmex.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookService extends Service {

    private static final String tag = "bookService";
    IBookSerViceImpl IBookManager;

    private AtomicBoolean mIsServiceDestoryed = new AtomicBoolean(false);
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();
    private RemoteCallbackList<IOnNewBookArrivedListener> mListenerList = new RemoteCallbackList<>();


    public BookService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1, "Android"));
        mBookList.add(new Book(2, "java"));
        mBookList.add(new Book(3, "sql"));
        IBookManager = new IBookSerViceImpl();
        new Thread(new ServiceWorker()).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return IBookManager.asBinder();
    }

    private void onNewBookArrived(Book book) throws RemoteException {
        mBookList.add(book);
        Log.d(tag, "onNewBookArrived");
        int N = mListenerList.beginBroadcast();
        for (int i = 0; i < N; i++) {
            IOnNewBookArrivedListener listener = mListenerList.getBroadcastItem(i);
            Log.d(tag, "notify listener " + i);
            if (listener != null) {
                listener.onNewBookArrived(book);
            }
        }
        mListenerList.finishBroadcast();
    }

    class IBookSerViceImpl extends IBookManager.Stub {

        public IBookSerViceImpl() {

        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            Log.d(tag, "getBookList:" + mBookList.toString());
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            if (!mBookList.contains(book)) {
                mBookList.add(book);
                Log.d(tag, "add:" + book.toString());
            } else {
                Log.d(tag, "the book already exists");
            }
            Log.d(tag, "book size:" + mBookList.size());
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
//            if (!mListenerList.contains(listener)) {
//                mListenerList.add(listener);
//                Log.d(tag, "add:" + listener.toString());
//            } else {
//                Log.d(tag, " listener already exists");
//            }
//            Log.d(tag, "listener size:" + mListenerList.size());

            mListenerList.register(listener);
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
//            if (mListenerList.contains(listener)) {
//                mListenerList.add(listener);
//                Log.d(tag, "remove:" + listener);
//            } else {
//                Log.d(tag, "no found,can not unregister");
//            }
//            Log.d(tag, "listener size:" + mListenerList.size());
            mListenerList.unregister(listener);
        }
    }

    private class ServiceWorker implements Runnable {

        @Override
        public void run() {
            while (!mIsServiceDestoryed.get()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int bookId = mBookList.size() + 1;
                Book newBook = new Book(bookId, "new Book#" + bookId);
                try {
                    onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
//        @Override
//        public void binderDied() {
//            if (IBookManager == null){
//                return;
//            }
//
//            IBookManager.asBinder().unlinkToDeath(mDeathRecipient,0);
//            IBookManager = null;
//            // 重新绑定
//            onBind();
//        }
//    };


}
