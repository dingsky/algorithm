package sort

import "testing"

func TestBubbleSort(t *testing.T) {
	array := []int{2, 3, 1, 5, 9, 7, 6, 11, 13, 2, 3, 5, 11, 9, 8, 12, 1}
	BubbleSort(array)
	t.Log(array)
}
