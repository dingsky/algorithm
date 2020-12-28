package sort;

import java.util.Random;

// 功能: 希尔排序(插入排序的优化版本)
// 算法: 先将数组一份为2, 将每一份数据进行插入排序, 再一份为四, 将每一份数据进行插入排序, 直到单个数组大小为1, 则数组为有序
// 说明: https://www.cnblogs.com/chengxiao/p/6104371.html
public class ShellSort {
    public static void sort(int[] array) {
        for(int dk = array.length/2; dk >= 1; dk /= 2) {
            for(int i= dk; i<array.length; i++) {
                int j = i;
                while(j-dk >= 0 && array[j] < array[j-dk]) {
                    int tmp = array[j];
                    array[j] = array[j-dk];
                    array[j-dk] = tmp;
                    j -= dk;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000];

        Random random = new Random();
        for(int i=0; i<1000; i++) {
            array[i] = random.nextInt(1000);
        }
        sort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
