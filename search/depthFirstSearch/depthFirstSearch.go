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
	path := make([][]int64, 0)
	pathResult := make([][]int64, 0)

	walk(&mapArray, 0, 0, 0, &min, &path, &pathResult)
	fmt.Printf("%d", min)
	fmt.Println("path:",pathResult)
}



func walk(mapArray *[5][5]int64, x,y, steps int64, min *int64, path *[][]int64, pathResult *[][]int64) {

	// 分别向右, 下, 左, 上走
	var i int
	for i=0; i<4; i++ {
		x += walkStep[i][0]
		y += walkStep[i][1]
		steps++
		if x < 0 || x >= 5 || y < 0 || y >=5 || mapArray[x][y] == 1 || mapArray[x][y] == 2 {
			//if x < 0 || x >= 5 || y < 0 || y >=5 {
			//	*path = (*path)[0:0]
			//}
	//		fmt.Println("path before:", *path)
	//		fmt.Println("path after:", *path)
			continue
		}


		if mapArray[x][y] == 9 {
			if *min == 0 || steps < *min {
				*pathResult = (*path)[0:]
				fmt.Printf("result:%v\n", *pathResult)
				*path =  (*path)[0:0]
		//		fmt.Println("result:", *pathResult)
		//		fmt.Printf("steps:%d x:%d y:%d\n", steps, x, y)
				*min = steps
			}
		} else {
		//	fmt.Printf("step:%d x:%d y:%d\n", steps, x,y)
			mapArray[x][y] = 2
			*path = append(*path, []int64{x,y})
//			fmt.Println("path:", *path)
			//	fmt.Println("path:", *path)
			walk(mapArray, x, y, steps, min, path, pathResult)
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

