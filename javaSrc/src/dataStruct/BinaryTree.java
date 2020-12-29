package dataStruct;

// 功能: 实现棵搜索二叉树
// TODO:现在跑出来的结果是不对的
public class BinaryTree {

    // 数据存储
    Integer data;

    // 左子树
    BinaryTree leftTree;

    // 右子树
    BinaryTree rightTree;

    // 插入一个节点
    public BinaryTree insert(int data) {
        if(this.data == null) {
            this.data = data;
            return this;
        }

        if(this.data > data) {
            if(leftTree == null) {
                leftTree = new BinaryTree();
            }
            leftTree.insert(data);
        } else {
            if(rightTree == null) {
                rightTree = new BinaryTree();
            }
            rightTree.insert(data);
        }
        return this;
    }

    // 查找一个节点

    // 前序遍历
    public void show() {
        if(this.data == null) {
            return;
        }
        System.out.printf("%d ", this.data);

        if(this.leftTree != null) {
            leftTree.show();
        }

        if(this.rightTree != null) {
            rightTree.show();
        }

    }

    // 中序遍历

    // 后序遍历
}

class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10).insert(5).insert(20).insert(8).insert(30).insert(70).insert(80).insert(2).insert(1000);
        binaryTree.show();
    }
}