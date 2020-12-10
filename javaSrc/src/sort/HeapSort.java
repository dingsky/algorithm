package sort;

import java.util.Random;

// 功能: 堆排序
// 算法: 堆排序本质上把线性结构当做完全二叉树来处理, 每个节点i的子节点为2i+1和2i+2, 有length/2个节点有子节点, 在线性结构中
// 数是通过层序遍历的方式铺开的, 首先先将数组构建为一个大顶堆, 然后第一元素和最后一个元素互换, 这样保证最后一个元素最大, 再
// 将前面length-1个元素的堆重新构建, 然后再讲对顶元素移动到倒数第二个位置, 直到堆的大小为1, 数组就有序了
public class HeapSort {
    public static void sort(int[] array) {
        for(int i=array.length-1; i > 0; i--) {
            // 重新构建大顶堆
            adjustHeap(array, i);
     //       showArray("array", array);

            // 将堆顶最大的元素, 替换到数组尾部
            swap(array, 0, i);
        }
    }

    private static void  adjustHeap(int[] array, int length) {

        // 从最后一个非叶子节点还是调整堆
        for(int i=length/2 -1; i>=0; i--) {
            adjustHeapNode(array, i);
        }
    }

    private static void adjustHeapNode(int[] array, int nodeIndex) {
        int left = nodeIndex * 2 + 1;
        int right = left + 1;
        // 如果左右节点有比当前节点大的元素, 则将当前节点和孩子节点中较大的替换
        if(array[left] > array[nodeIndex] || array[right] > array[nodeIndex]) {
            int max = array[left] > array[right]?left:right;
            swap(array, nodeIndex, max);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static void showArray(String name, int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.println(name + ": " + i + "num:" + array[i]);
        }
        System.out.println("===========================================");
    }

    public static void main(String[] args) {
        int[] array = new int[10000];

        Random random = new Random();
        for(int i=0; i<10000; i++) {
            array[i] = random.nextInt(10000);
        }
//        for(int i : array) {
//            System.out.println(i);
//        }

        sort(array);
        System.out.println("===========================");
        for(int i : array) {
            System.out.println(i);
        }
    }
}
