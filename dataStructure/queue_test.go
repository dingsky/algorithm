package dataStructure

import "testing"

func TestQueue(t *testing.T) {
	queue := new(Queue)
	queue.InQueue(1)
	queue.InQueue(2)
	queue.InQueue(3)
	head, _ := queue.Head()
	tail, _ := queue.Tail()
	t.Log("size:", queue.Size(), "head:", head, "tail:", tail)
	head, _ = queue.OutQueue()
	t.Log("head:", head, "size:", queue.Size())
	head, _ = queue.OutQueue()
	t.Log("head:", head, "size:", queue.Size())
	if ! queue.IsEmpty() {
		t.Log("is not empty")
	}
	head, _ = queue.OutQueue()
	t.Log("head:", head, "size:", queue.Size())
	if queue.IsEmpty() {
		t.Log("is empty")
	}
}
