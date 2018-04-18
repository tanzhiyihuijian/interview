package cn.com.dom4j.adt.link;

public class Node<AnyType extends Comparable<? super AnyType>> {

    private AnyType value;
    private Node<AnyType> next;

    public Node() {

    }

    public Node(AnyType value) {
        this.value = value;
    }

    public Node(AnyType value, Node<AnyType> next) {
        this.value = value;
        this.next = next;
    }

    public void Node(AnyType value) {
        this.value = value;
    }

    public AnyType getValue() {
        return value;
    }

    public void setValue(AnyType value) {
        this.value = value;
    }

    public Node<AnyType> getNext() {
        return next;
    }

    public void setNext(Node<AnyType> next) {
        this.next = next;
    }
}
