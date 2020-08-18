package main

import "fmt"

var array, book [10]int64
var n int64

func setCards(step int64) {
	if step == n  {
		for _, val := range array {
			fmt.Printf("%d", val)
		}
		fmt.Printf("\n")
		return
	}

	var i int64
	for i=0; i<n; i++{
		if book[i] == 0 {
			array[step] = i+1
			book[i] = 1
			setCards(step + 1)
			book[i] = 0
		}

	}
}

func main() {
	n = 3
	setCards(0)
}