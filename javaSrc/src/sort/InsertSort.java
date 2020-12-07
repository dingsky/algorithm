package sort;

import java.util.Random;

// 功能: 插入排序
// 基本思想: 将新的数据插入已有序的序列, 类似抓扑克牌.
// 时间复杂度: O(N^2)
// 空间复杂度: O(1)
public class InsertSort {
    public static void sort(int[] array) {
        int key, j;

        // 遍历没有插入的无序剩余数据
        for(int i=1; i < array.length; i++) {

            // 保存需要插入的数据
            key = array[i];

            // 从有序数据最后一个开始, 如果该数据比插入的数据大, 则往后挪一个, 直到找到一个比插入数据小的, 然后插进去
            for(j = i-1; j>=0 && array[j] > key; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100000];

        Random random = new Random();
        for(int i=0; i<100000; i++) {
            array[i] = random.nextInt(100000);
        }
        sort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
