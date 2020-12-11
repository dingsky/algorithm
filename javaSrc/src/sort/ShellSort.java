package sort;

// 功能: 希尔排序(插入排序的优化版本)
// 算法: 先将数组一份为2, 将右边的插入左边的, 再一份为四, 将右边的插入左边的, 直到单个数组大小为1, 则数组为有序
public class ShellSort {
    public static void sort(int[] array) {
        for(int dk = array.length/2; dk >= 1; dk /= 2) {
            for(int i= dk; i<array.length; i++) {

            }
        }
    }
}
