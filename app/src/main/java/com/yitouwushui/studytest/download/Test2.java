package com.yitouwushui.studytest.download;

/**
 * Created by ding on 2017/9/13.
 */

public class Test2 {

    public static void main(String[] args){
        System.out.print(new B().getValue());
    }

    static class A{
        protected int value;

        public A(int value)


        {
            setValue(value);
        }


        public void setValue(int value) {
            this.value = value;
        }
        public int getValue(){
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() -3);
        }

        @Override
        public void setValue(int value) {
            super.setValue(2*value);
        }
    }
}
