package sort

// 排序名： 冒泡排序
// 基本思想：两两比较大小, 将较大(小)的向后移动, 每一轮交换至少可以让一个元素到达预期的为止, 直到数组有序为止
// 时间复杂度: O(N^2)
// 空间复杂度: O(1)

func BubbleSort(array []int) {
	length := len(array)
	isSwap := true
	for i:=0; i<length && isSwap; i++ {
		isSwap = false
		for j:=0; j<length-i-1; j++ {
			if array[j] > array[j+1] {
				array[j], array[j+1] = array[j+1], array[j]
				isSwap = true
			}
		}
	}
}
