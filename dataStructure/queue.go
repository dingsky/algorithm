package dataStructure

import "errors"

type Queue struct {
	queue []int64
	size int64
}

func(q *Queue)Size ()int64{
	return q.size
}

func(q *Queue) InQueue(data int64) {
	q.queue = append(q.queue, data)
	q.size++
}

func(q *Queue) OutQueue()(int64, error) {
	if q.size <= 0 {
		return 0, errors.New("queue is empty")
	}
	data := q.queue[0]
	q.queue = q.queue[1:]
	q.size--
	return data, nil
}

func(q *Queue) Head()(int64, error) {
	if q.size <= 0 {
		return 0, errors.New("queue is empty")
	}
	return q.queue[0], nil
}

func(q *Queue) Tail()(int64, error) {
	if q.size <= 0 {
		return 0, errors.New("queue is empty")
	}
	return q.queue[len(q.queue)-1], nil
}

func(q *Queue) IsEmpty() bool {
	return q.size == 0
}