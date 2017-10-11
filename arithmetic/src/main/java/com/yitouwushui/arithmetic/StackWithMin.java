package com.yitouwushui.arithmetic;

import java.util.Stack;

/**
 * Created by ding on 2017/10/11.
 */

public class StackWithMin extends Stack<Integer> {

    private Stack<Integer> minStack=new Stack<>();
    private Stack<Integer> dataStack=new Stack<>();

    public static void main(String[] args) {
        StackWithMin test=new StackWithMin();
        test.push(3);
        test.push(2);
        test.push(1);
        test.push(4);
        test.push(5);
        System.out.println(test.min());
    }

    @Override
    public Integer push(Integer item) {
        dataStack.push(item);
        if (minStack.size() == 0 || item <= minStack.peek()){
            minStack.push(item);
        } else {
            // 重复之前的最小值
            minStack.push(minStack.peek());
        }
        return item;
    }

    @Override
    public synchronized Integer pop() {
        if (dataStack.size() == 0 || minStack.size() == 0){
            return null;
        }
        minStack.pop();
        return dataStack.pop();
    }

    public Integer min(){
        if (dataStack.size() == 0 || minStack.size() == 0){
            return null;
        }
        dataStack.pop();
        return minStack.pop();
    }
}
