package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/11.
 */

public class Hanio {

    public void hanio(int n, char x, char y, char z) {
        if (n == 1) move(x, n, z);

        else {
            hanio(n - 1, x, z, y);
            move(x, n, z);
            hanio(n - 1, y, x, z);
        }
    }

    private void move(char x, int n, char y) {
        System.out.println("Move " + n + " from " + x + " to " + y);
    }


    public void coding(int[] b, int n) {
        if (n == 0) {
            b[n] = 0;
            outBn(b);
            b[n] = 1;
            outBn(b);
        } else {
            b[n] = 0;
            coding(b, n - 1);
            b[n] = 1;
            coding(b, n - 1);
        }
    }

    private void outBn(int[] b) {
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i]);
        System.out.println();
    }

    public static void main(String args[]) {
        Hanio hanio = new Hanio();
//        Hanio.Hanio(3, 'a', 'b', 'c');

        int n = 2;
        int[] b = new int[n];
        hanio.coding(b,n-1);
    }
}
