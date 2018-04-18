package cn.com.dom4j.adt.tree;

/**
 * 二叉树节点
 */
public class BinaryNode<AnyType> {

    private AnyType value;
    private BinaryNode<AnyType> left;
    private BinaryNode<AnyType> right;

    public BinaryNode() {
    }

    public BinaryNode(AnyType value) {
        this.value = value;
    }

    public BinaryNode(AnyType value, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public AnyType getValue() {
        return value;
    }

    public void setValue(AnyType value) {
        this.value = value;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<AnyType> left) {
        this.left = left;
    }

    public BinaryNode<AnyType> getRight() {
        return right;
    }

    public void setRight(BinaryNode<AnyType> right) {
        this.right = right;
    }
}
