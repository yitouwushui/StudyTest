// IBinderPool.aidl
package com.yitouwushui.binderpool;

// Declare any non-default types here with import statements

interface IBinderPool {

    // 查询binder
    IBinder queryBinder(int binderCode);
}
