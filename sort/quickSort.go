package sort

// 排序名： 快速排序
// 基本思想：
//

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
