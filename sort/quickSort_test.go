package sort

import "testing"

func TestQuickSort(t *testing.T) {
	array := []int{2, 3, 1, 5, 9, 7, 6, 11, 13, 2, 3, 5, 11, 9, 8, 12, 1}
	QuickSort(array)
	t.Log(array)
}
