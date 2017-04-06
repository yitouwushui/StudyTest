package com.yitouwushui.binderpool;

import android.os.RemoteException;

/**
 * Created by ding on 2017/3/27. 加
 */
public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
