package dataStructure

import "testing"

func TestStack(t *testing.T) {
	stack := new(Stack)
	stack.Push(1)
	stack.Push(2)
	stack.Push(3)
	stack.Push(1.3)
	top, _ := stack.Top()
	t.Log("top:", top)

	pop, _:= stack.Pop()
	t.Log("size:", stack.Size(), "pop:", pop)
	pop, _= stack.Pop()
	t.Log("size:", stack.Size(), "pop:", pop)
}
