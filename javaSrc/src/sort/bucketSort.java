package sort;

import java.util.Random;

// 功能: 桶排序
// 基本思想: 遍历数组,讲数组存入有序的桶中, 记录每个桶出现的次数, 然后再遍历一遍桶
// 时间复杂度:
// 空间复杂度: O(N)
public class bucketSort {
    public static void sort(int[] array) {
        int[] bucket = new int[256];

        // 遍历数组, 放入桶中
        for(int i=0; i < array.length; i++) {
            bucket[array[i]]++;
        }


        // 遍历桶, 拿出有序数据
        for(int i=0, j=0; i < 256; i++) {
            while(bucket[i] > 0) {
                array[j] = i;
                j++;
                bucket[i]--;
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
