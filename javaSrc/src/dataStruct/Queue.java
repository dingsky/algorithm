package dataStruct;

import javax.swing.plaf.synth.SynthTextAreaUI;

// 实现一个队列
public class Queue {

    // 数据存储
    private int[] data;

    // 容量
    private int capicity;

    // 大小
    private int size;

    // 构造方法
    public Queue(int capicity) {
        this.capicity = capicity;
        data = new int[capicity];
    }

    // 入队
    public Queue in(int data) {
        if(size+1 > capicity) {
            return this;
        }
        this.data[size++] = data;
        return this;
    }

    // 出队
    public int out(){
        if(isEmpty()) {
            return 0;
        }
        int result = data[0];
        for(int i=0; i<size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        return result;
    }

    // 大小
    public int size() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size <= 0;
    }

    // 打印
    public void show() {
        for(int i=0; i<size; i++) {
            System.out.printf("%d ", data[i]);
        }
        System.out.println("");
    }
}

class TestQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(100);
        queue.in(10).in(20).in(30).in(40).in(50).in(60).in(70).in(80).in(90).in(100);
        queue.show();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.out());
        System.out.println(queue.out());
        queue.show();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
