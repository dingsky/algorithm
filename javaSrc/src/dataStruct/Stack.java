package dataStruct;

// 实现一个栈
public class Stack {

    // 数组存储
    private int[] data;

    // 容量
    private int capicity;

    // 当前大小
    private int size;

    // 构造方法
    public Stack(int capicity) {
        this.capicity = capicity;
        data = new int[capicity];
    }

    // 入栈
    public Stack push(int data) {
        if(size+1 > capicity) {
            return this;
        }

        this.data[size++] = data;
        return this;
    }

    // 出栈
    public int pop() {
        int top = this.data[size-1];
        size--;
        return top;
    }

    // 获取栈顶
    public int top() {
        return this.data[size-1];
    }

    // 栈是否为空
    public boolean isEmpty() {
        return size <= 0;
    }

    // 栈大小
    public int size() {
        return size;
    }

    // 打印栈
    public void show() {
        for(int i=0; i<size; i++) {
            System.out.printf("%d ", data[i]);
        }
        System.out.println("");
    }

}

class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack(100);
        stack.push(1).push(2).push(100).push(50).push(200).push(1000);
        stack.show();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
