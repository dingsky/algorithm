package sort;

import java.util.Random;

// 功能: 归并排序
// 基本思想: 把一个大的数组, 拆成两个小的, 让这两个小的有序, 然后把这两个有序的数据合并(双指针移动)
public class mergeSort {
    public static int[] mergeSort(int[] array) {

        // 当只有一个元素的时候, 不可再分割, 且已有序
        if(array.length <= 1) {
            return array;
        }

        // 将一个数组分割成两个有序的数组
        int mid = array.length / 2;
        int[] leftArray = cutArray(array, 0, mid);
        int[] rightArray = cutArray(array, mid+1, array.length - 1);
        int[] sortLeftArray = mergeSort(leftArray);
        int[] sortRightArray = mergeSort(rightArray);

        for(int i=0; i<sortLeftArray.length; i++) {
            System.out.println("leftArray:" + i + "num:" + sortLeftArray[i]);
        }
        System.out.println("===========================================");

        for(int i=0; i<sortRightArray.length; i++) {
            System.out.println("rightArray:" + i + "num:" + sortRightArray[i]);
        }
        System.out.println("===========================================");


        // 创建一个结果集
        int[] result = new int[sortLeftArray.length + sortRightArray.length];

        // 合并两个有序数组
        int i=0, j=0, l=0;
        for(; i < sortLeftArray.length && j < sortRightArray.length;) {
            result[l++] = sortLeftArray[i] < sortRightArray[j]?sortLeftArray[i++]:sortRightArray[j++];
        }

        for(;i<sortLeftArray.length; i++) {
            result[l++] = sortLeftArray[i];
        }
        for(;j<sortRightArray.length; j++) {
            result[l++] = sortRightArray[j];
        }
        return result;
    }

    private static int[] cutArray(int[] array, int start, int end) {
        int[] result = new int[end - start + 1];
        for(int i=start, j=0; i<end; i++, j++) {
            result[j] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[20];

        Random random = new Random();
        for(int i=0; i<20; i++) {
            array[i] = random.nextInt(20);
        }
        for(int i : array) {
            System.out.println(i);
        }
        mergeSort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }

}
