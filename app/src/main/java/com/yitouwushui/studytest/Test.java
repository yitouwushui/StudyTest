package com.yitouwushui.studytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import retrofit2.http.GET;


/**
 * Created by ding on 2017/4/13.
 */
public class Test {
//    public interface ITest {
//        @GET("/heiheihei")
//        public void add(int a, int b);
//
//    }
//    public static void main(String[] args) {
//        ITest iTest = (ITest) Proxy.newProxyInstance(ITest.class.getClassLoader(), new Class<?>[]{ITest.class}, new InvocationHandler()
//        {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
//            {
//                Integer a = (Integer) args[0];
//                Integer b = (Integer) args[1];
//                System.out.println("方法名：" + method.getName());
//                System.out.println("参数：" + a + " , " + b);
//
//                GET get = method.getAnnotation(GET.class);
//                System.out.println("注解：" + get.value());
//                return null;
//            }
//        });
//        iTest.add(3, 5);
//    }

    static int count = 0;

    public static boolean find(int[][] array,int number){
        if (array == null){
            return false;
        }
        int column = array[0].length - 1;
        int row = 0;
        while (row < array.length && column >= 0){
            count++;
            if (array[row][column] == number){
                return true;
            }
            if (array[row][column] > number){
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static boolean findFor(int[][] array,int number){
        if(array == null){
            return false;
        }

        int columnLength = array[0].length;
        for (int row = array.length - 1 ,column = 0;row >= 0 && column <columnLength;){
            count++;
            if (array[row][column] == number){
                return true;
            }
            if (array[row][column] < number){
                column++;
            } else {
                row--;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int[][] testarray=new int[4][4];
        testarray[0][0]=1;
        testarray[0][1]=2;
        testarray[0][2]=8;
        testarray[0][3]=9;
        testarray[1][0]=2;
        testarray[1][1]=4;
        testarray[1][2]=9;
        testarray[1][3]=12;
        testarray[2][0]=4;
        testarray[2][1]=7;
        testarray[2][2]=10;
        testarray[2][3]=13;
        testarray[3][0]=6;
        testarray[3][1]=8;
        testarray[3][2]=11;
        testarray[3][3]=15;
        System.out.println(findFor(testarray, 11));
        System.out.println(count);
    }
}
