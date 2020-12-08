package sort;

import java.util.Random;

// 功能: 选择排序
// 基本思想: 每次从剩余的数组里面选一个最小的放到当前已有序序列的末尾
// 时间复杂度: O(N^2)
// 空间复杂度: O(1)
public class SelectSort {
    public static void sort(int[] array) {
        int min, index;
        for(int i=0; i< array.length; i++) {

            // 从剩余的数字里取一个最小的
            min = array[i];
            index = i;
            for(int j=i; j<array.length; j++) {
                if(array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }

            // 将最小的数当前要排序的位置交换
            array[index] = array[i];
            array[i] = min;
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
