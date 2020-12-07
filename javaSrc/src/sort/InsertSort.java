package sort;

// 功能: 插入排序
// 基本思想: 将新的数据插入已有序的序列, 类似抓扑克牌.
// 时间复杂度: O(N^2)
// 空间复杂度: O(1)
public class InsertSort {
    public static void sort(int[] array) {
        int key, j;
        for(int i=1; i < array.length; i++) {
            key = array[i];
            for(j = i-1; j>=0 && array[j] > key; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {6,3,5,4,9,8,6,7};
        sort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
