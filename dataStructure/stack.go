package dataStructure

import (
	"errors"
)

type Stack struct {
	stack []interface{}
	size int64
}

func (s *Stack)Push(data interface{}) {
	slice := s.stack
	s.stack = make([]interface{},0, 1000)
	s.stack = append(s.stack, data)
	s.stack = append(s.stack, slice...)
	s.size++
}

func (s *Stack)Pop() (interface{}, error) {
	if s.size <= 0 {
		return 0, errors.New("stask is empty")
	}

	data := s.stack[0]
	s.stack = s.stack[1:]
	s.size--
	return data, nil
}

func (s *Stack)Top() (interface{}, error) {
	if s.size <= 0 {
		return 0, errors.New("stask is empty")
	}
	return s.stack[0], nil
}

func (s *Stack)Size() int64 {
	return s.size
}

func (s *Stack)IsEmpty() bool {
	return s.size == 0
}
