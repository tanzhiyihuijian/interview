package cn.com.dom4j.adt.tree;

public class AVLNode<T extends Comparable<? super T>> {

    private T value;
    private AVLNode<T> left;
    private AVLNode<T> right;

    private int hight;

    public AVLNode() {
    }

    public AVLNode(T value) {
        this.value = value;
    }

    public AVLNode(T value, AVLNode<T> left, AVLNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public AVLNode(T value, AVLNode<T> left, AVLNode<T> right, int hight) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.hight = hight;
    }
}
