package dataStructure

import "fmt"

type nodeDef struct {
	data interface{}
	next *nodeDef
}

type List struct {
	head *nodeDef
	tail *nodeDef
	size int64
}

func NewList() *List {
	list := new(List)
	list.head = new(nodeDef)
	list.tail = new(nodeDef)
	list.size = 0
	return list
}

func (l *List)HeadInsert(data interface{}) {
	node := new(nodeDef)
	node.data = data

	next := l.head.next
	l.head.next = node
	node.next = next

	if l.tail.next == nil {
		l.tail.next = node
	}
	l.size++
}

func (l *List)TailInsert(data interface{}) {
	node := new(nodeDef)
	node.data = data

	l.size++
	if l.tail.next == nil {
		l.tail.next = node
		l.head.next = node
		return
	}

	l.tail.next.next = node
	l.tail.next = node
}

func (l *List)Size() int64 {
	return l.size
}

func(l *List)Travel() {
	tmp := l.head.next
	for ;tmp != nil; tmp=tmp.next {
		fmt.Printf("%v ", tmp.data)
	}
	fmt.Printf("\n")
}
