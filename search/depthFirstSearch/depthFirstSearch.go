package main

import "fmt"

// map 是一张地图, 如果一个元素为0表示可以通过, 为1表示是障碍物, 为2表示已走过, 9表示目的地
// 起始位置都为[0,0]
// 需要返回坐标[0,0]到目的地的最短路径
// 搜索的尝试顺序是右、下、左、上
// 使用深度优先搜索算法

var walkStep = [4][2]int64{
	{1, 0},
	{0, 1},
	{-1, 0},
	{0, -1},
}


func GetShortestPath(mapArray [5][5]int64) {
	var min int64
	walk(&mapArray, 0, 0, 0, &min)
	fmt.Printf("%d", min)
}



func walk(mapArray *[5][5]int64, x,y, steps int64, min *int64) {

	// 分别向右, 下, 左, 上走
	for i:=0; i<4; i++ {
		x += walkStep[i][0]
		y += walkStep[i][1]
		if x < 0 || x >= 5 || y < 0 || y >=5 || mapArray[x][y] == 1 || mapArray[x][y] == 2 {continue}
		if mapArray[x][y] == 9 {
			if *min == 0 || steps < *min {
				*min = steps
			}
		} else {
			mapArray[x][y] = 2
			walk(mapArray, x, y, steps+1, min)
			mapArray[x][y] = 0
		}
	}
}

func main () {
	mapArray := [5][5]int64{
		{0,1,0,0,0},
		{0,0,0,1,0},
		{0,0,1,9,0},
		{0,0,0,1,0},
		{0,0,0,1,0},
	}

	GetShortestPath(mapArray)
}

