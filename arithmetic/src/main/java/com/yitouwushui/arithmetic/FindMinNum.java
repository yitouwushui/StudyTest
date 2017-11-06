package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/22.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的
 * 旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数
 * 组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1.
 */
public class FindMinNum {

    public static void main(String args[]) {

    }

    public Integer findMinNum(int[] array) {
        if (array == null) {
            return null;
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int mid = 0;
        while (array[leftIndex] >= array[rightIndex]) {
            if (rightIndex - leftIndex <= 1) {
                mid = rightIndex;
                break;
            }
            mid = (leftIndex + rightIndex) / 2;
            if (array[leftIndex] == array[rightIndex] && array[leftIndex] == array[mid]) {
                // 有重复数字的情况
                if (array[leftIndex + 1] != array[rightIndex - 1]) {
                    mid = array[leftIndex + 1] < array[rightIndex - 1] ? (leftIndex + 1) : (rightIndex - 1);
                    break;
                } else {
                    leftIndex++;
                    rightIndex--;
                }
            } else {
                if (array[mid] >= array[leftIndex]) {
                    leftIndex = mid;
                } else {
                    if (array[mid] <= array[rightIndex]) {
                        rightIndex = mid;
                    }
                }
            }
        }
        return array[mid];
    }

}
