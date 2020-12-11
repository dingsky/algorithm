package sort;

import java.util.Random;

// 功能: 快速排序
// 算法: 先取第一个数为基准值, 保存下来X=A[0], A[0]挖了一个坑, 从最右边R开始寻找一个小于A的数, 然后把它放到A[0]
// 这时出现一个新的坑, 从1开始寻找一个比X大的数放到过去, 然后再往左边扫
// 直到两个指针相遇, 然后把X放进去, 做到X左边都比他小, 右边比他大
// 然后再通过分治的思想, 把一个数组拆成更小的两部分, 直到无法拆分
public class quickSort {
    public static void quickSort(int[] array, int left, int right) {
        if(left < right) {
            int i = left, j = right, x = array[left];
            while(i < j) {
                // 从右边找一个比基准值小的, 填到左边的坑
                while(i < j && array[j] > x)
                    j--;
                if(i < j)
                    array[i++] = array[j];

                // 从左边找一个比基准值大的, 填充到右边的坑
                while(i < j && array[i] < x)
                    i++;
                if(i < j)
                    array[j--] = array[i];
            }
            array[i] = x;
            quickSort(array, left, i-1);
            quickSort(array, i+1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000];

        Random random = new Random();
        for(int i=0; i<1000; i++) {
            array[i] = random.nextInt(1000);
        }
//        for(int i : array) {
//            System.out.println(i);
//        }
        quickSort(array, 0, array.length-1);
        System.out.println("===========================================");

        for(int i : array) {
            System.out.println(i);
        }
    }
}
