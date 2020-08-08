package sort

// 排序名称：桶排序
// 基本原理：分配N个桶, 遍历数组，数字放进对应的桶里, 然后再从桶中将数字按顺序拿出来形成一个有序数组
// 时间复杂度: O(M+N), M为桶数量, N为数组长度
// 空间复杂度: O(M)

// 实现一个简易的桶排序
func BucketSort(array []int) {
	var bucket [255]int
	for _, val := range array {
		bucket[val]++
	}

	for i,k := 0, 0; i < 255; i=i+1 {
		for j := 0; j < bucket[i]; j,k=j+1, k+1 {
			array[k] = i
		}
	}
}
