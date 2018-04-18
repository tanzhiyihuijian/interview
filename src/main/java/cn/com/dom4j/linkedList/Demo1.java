package cn.com.dom4j.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {


        List<String> list = Arrays.asList("a", "b", "c");

        Node<String> node = createLinkedList(list);

        /*while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }*/

        /*node = reverseLinkedList(node);
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }*/

        combinations(new ArrayList<Integer>(), Arrays.asList(1, 2, 3, 4), 2);



    }

    // 传入一个集合, 创建一个链表, 链表的最后一个节点是 null, 并且方法返回第一个节点
    private static <T> Node<T> createLinkedList(List<T> list) {

        if (list.isEmpty()) {
            return null;
        }

        Node<T> node = new Node<T>(list.get(0));

        node.setNext(createLinkedList(list.subList(1, list.size())));

        return node;
    }

    // 链表反转
    private static <T> Node<T> reverseLinkedList(Node<T> head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<T> newHead = reverseLinkedList(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;

    }

    // 列出所有的组合
    private static void combinations(List<Integer> selected, List<Integer> data, int n) {

        if (n == 0) {
            // output empty list
            System.out.println(selected);
            return;
        }

        if (data.isEmpty()) {
            return;
        }

        // select element 0
        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n - 1);

        // un-select element 0
        selected.remove(selected.size() - 1);
        combinations(selected, data.subList(1, data.size()), n);






    }



}
