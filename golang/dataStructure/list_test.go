package dataStructure

import "testing"

func TestList(t *testing.T) {
	list := NewList()

	list.TailInsert("4")
	list.HeadInsert("2")
	list.TailInsert("5")
	list.HeadInsert("1")
	list.TailInsert("6")
	list.HeadInsert("3")
	t.Log("size:", list.size)
	list.Travel()
}
