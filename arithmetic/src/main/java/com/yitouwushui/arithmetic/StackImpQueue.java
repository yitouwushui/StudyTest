package com.yitouwushui.arithmetic;

import java.util.Stack;

/**
 * Created by ding on 2017/8/16.
 */

public class StackImpQueue {

    private Stack<Object> stack1 = new Stack<>();
    private Stack<Object> stack2 = new Stack<>();

    public void appendTail(Object o){
        stack1.push(o);
    }
    public Object deleteHead() throws Exception{
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return new Exception("数据为空，不能删除");
        }
        return stack2.pop();
    }

    public void deleteAndPrint(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("is empty");
        }
        while (!stack2.isEmpty()){
            System.out.println(stack1.pop());
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }
    }

    public static void main(String args[]){
        StackImpQueue stackImpQueue = new StackImpQueue();
        stackImpQueue.appendTail("1");
        stackImpQueue.appendTail("2");
        stackImpQueue.appendTail("3");
        try {
            stackImpQueue.deleteHead();
            stackImpQueue.deleteAndPrint();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
