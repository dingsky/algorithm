package dataStruct;

// 功能: 用JAVA实现一个单链表
class Node {

    // 数据存储
    private int data;

    // 下一个节点
    private Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class List {
    // 容量
    private int capacity;

    // 大小
    private int size;

    // 头节点
    Node head;

    // 尾结点
    Node tail;

    // 构造方法
    public List(int capacity) {
        this.capacity = capacity;
    }

    // 在表头插入
    public List headInsert(int data) {
        if(size > capacity) {
            return this;
        }

        Node node = new Node();
        node.setData(data);
        if(head == null) {
            head = node;
            if(tail == null) {
                tail = head;
            }
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
        return this;
    }

    // 在表尾插入
    public List tailInsert(int data) {
        if(size > capacity) {
            return this;
        }

        Node node = new Node();
        node.setData(data);
        if(tail == null) {
            tail = node;
            if(head == null) {
                head = tail;
            }
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
        return this;
    }

    // 判断一个链表是否为空
    public boolean isEmpty() {
        return this.size <= 0;
    }

    // 获取当前链表大小
    public int size() {
        return this.size;
    }

    // 遍历一个链表
    public void TravelList() {
        Node node = this.head;
        while(node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}

class TestList {
    public static void main(String[] args) {
        List list = new List(100);
        list.headInsert(10).headInsert(20).tailInsert(50).tailInsert(100).headInsert(110).tailInsert(500);
        list.TravelList();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
