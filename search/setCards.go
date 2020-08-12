package main

import "fmt"

var array, book [10]int64
var n int64

func setCards(step int64) {
	if step == n +1 {
		for _, val := range array {
			fmt.Printf("%d", val)
		}
	}

	var i int64
	for i=0; i<=n; i++{
		array[step] = i
		book[i] = 1
		setCards(step + 1)
		book[i] = 0
	}
}

func main() {
	n = 10
	setCards(1)
}