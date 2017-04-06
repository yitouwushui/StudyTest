// ISecurityCenter.aidl
package com.yitouwushui.binderpool;

// Declare any non-default types here with import statements

interface ISecurityCenter {
    // 加密
    String encrypt(String content);
    // 解密
    String decrypt(String password);
}
