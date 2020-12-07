package sort

// 排序名： 快速排序
// 基本思想：取第一个数字作为基数, 然后从右开始扫描, 找到一个比基数小的, 再从左边开始扫描，找到一个比基数大的，交换这两个数字，直到两边扫描的下标相遇或者穿过.
// 如果相遇, 那么说明左边的全部比基数小，右边的全部比基数大, 将基数交换到相遇的位置.然后对基数左右两边的序列再进行快速排序。
// 如果穿过，说明该序列已完成排序.
// 时间复杂度: 最坏O(N^2), 平均O(NLogN)
// 空间复杂度: O(1)

func QuickSort(array []int) {
	quickSort(array, 0, int64(len(array))-1)
}

func quickSort(array []int, start, end int64) {

	if start > end {
		return
	}

	mid := array[start]
	i, j := start, end

	for ; 	i < j; {
		for ;array[j] >= mid && i< j; j-- {}
		for ;array[i] <= mid && i < j; i++ {}
		if i < j {
			array[i], array[j] = array[j], array[i]
		}
	}

	array[start], array[i] = array[i], array[start]
	quickSort(array, start, i-1)
	quickSort(array, i+1, end)

}
