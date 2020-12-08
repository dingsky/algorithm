package main

import (
	"algorithm/golang/dataStructure"
	"fmt"
)

// 使用两个队列和一个栈实现一个小猫钓鱼的游戏(假设牌面是1-9)
// 各使用一个队列保存两个玩家手中的牌, 使用栈保存牌桌上的牌
// 出牌后判断栈中是否已存在该牌, 如果有(赢了)则栈中对应的元素出栈, 否则入栈
// 其中一个玩家手中的队列空了，则游戏结束

type gameDef struct {
	stack  dataStructure.Stack
	queue1 dataStructure.Queue
	queue2 dataStructure.Queue
}

func main() {
	game := new(gameDef)
	game.queue1.InQueue(2)
	game.queue1.InQueue(4)
	game.queue1.InQueue(1)
	game.queue1.InQueue(2)
	game.queue1.InQueue(5)
	game.queue1.InQueue(6)

	game.queue2.InQueue(3)
	game.queue2.InQueue(1)
	game.queue2.InQueue(3)
	game.queue2.InQueue(5)
	game.queue2.InQueue(6)
	game.queue2.InQueue(4)

	for !game.queue2.IsEmpty() && ! game.queue1.IsEmpty() {
		data, _ := game.queue1.OutQueue()
		index := game.stack.Index(data)
		if index >= 0 {
			game.queue1.InQueue(data)
			remain := game.stack.Size() - index-1
			for ;game.stack.Size() > remain; {
				out, _ := game.stack.Pop()
				game.queue1.InQueue(out)
			}
		} else {
			game.stack.Push(data)
		}
		fmt.Printf("User1 over, the play cards of user1 is :%v, user2 is:%v, the play cards of desk is：%v\n", game.queue1.ShowAll(), game.queue2.ShowAll(), game.stack.ShowAll())

		data, _ = game.queue2.OutQueue()
		index = game.stack.Index(data)
		if index >= 0 {
			game.queue2.InQueue(data)
			remain := game.stack.Size() - index-1
			for ;game.stack.Size() > remain; {
				out, _ := game.stack.Pop()
				game.queue2.InQueue(out)
			}
		} else {
			game.stack.Push(data)
		}
		fmt.Printf("User2 over, the play cards of user1 is :%v, user2 is:%v, the play cards of desk is：%v\n", game.queue1.ShowAll(), game.queue2.ShowAll(), game.stack.ShowAll())
	}
	if game.queue1.IsEmpty() {
		fmt.Printf("User2 Win, the play cards of user2 is :%v, the play cards of desk is：%v\n", game.queue2.ShowAll(), game.stack.ShowAll())
	} else {
		fmt.Printf("User1 Win, the play cards of user1 is :%v, the play cards of desk is：%v\n", game.queue1.ShowAll(), game.stack.ShowAll())
	}
}