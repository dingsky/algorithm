package sort;

import java.util.Random;

// 功能: 冒泡排序
// 基本思想: 两两交换, 把最小的一个放到第一个, 直到没有发生过交换或者遍历了所有的
// 时间复杂度: O(N^2)
// 空间复杂度: O(1)
public class bubbleSort {
    public static void sort(int[] array) {
        int tmp;
        boolean isSwap;
        for(int i=0; i <array.length; i++) {
            isSwap = false;
            for(int j=array.length-1; j>i; j--) {
                if(array[j] < array[j-1]) {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    isSwap = true;
                }
            }

            if(!isSwap) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[20];

        Random random = new Random();
        for(int i=0; i<20; i++) {
            array[i] = random.nextInt(20);
        }
        sort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
