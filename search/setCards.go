package main

import "fmt"

// 有count个数字, 放进对应的盒子里, 有多少种放法

func SetCards(count int64)[][]int64 {

	result:= make([][]int64, 0)
	array := make([]int64, count+1)
	book := make([]int64, count+1)
	setCards(array, book, &result, 1, count)
//	fmt.Println(result)
	return result
}


func setCards(array []int64, book []int64, result *[][]int64,step, count int64) {
	if step == count + 1  {
		destArray := make([]int64, len(array)-1)
		copy(destArray, array[1:])
		*result = append(*result, destArray)
		return
	}

	var i int64
	for i=1; i<count+1; i++{
		if book[i] == 0 {
			array[step] = i
			book[i] = 1
			setCards(array, book, result, step + 1, count)
			book[i] = 0
		}

	}
}


func main() {
	result := SetCards(10)
	for _, val := range result {
		fmt.Println(val)
	}
}