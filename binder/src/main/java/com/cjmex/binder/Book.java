package com.cjmex.binder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ding on 2017/3/9.
 */

public class Book implements Parcelable {

    private int bookId;
    private String bookName;


    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }


    public Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            if (book.bookId == this.bookId) {
                return true;
            } else {
                return false;
            }
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
