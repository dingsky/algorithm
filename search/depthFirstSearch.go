package main

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
	walk(&mapArray, 0, 0, 0)
}



func walk(mapArray *[5][5]int64, x,y, steps int64, min *int64) {

	// 分别向右, 下, 左, 上走
	for i:=0; i<4; i++ {
		x += walkStep[i][0]
		y += walkStep[i][1]
		if mapArray[x,y] == 9 {

		}
	}
}

func main () {
	mapArray := [][]int64{
		{0,1,0,0,0},
		{0,0,0,1,0},
		{0,0,1,9,0},
		{0,0,0,1,0},
		{0,0,0,1,0},
	}

	GetShortestPath(mapArray)
}

