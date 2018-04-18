package cn.com.dom4j.adt;

import cn.com.dom4j.linkedList.Node;

import java.util.LinkedList;

public class A {

    class BinaryNode {
        private int value;
        private BinaryNode left;
        private BinaryNode right;

        public BinaryNode(int value) {
            this.value = value;
        }
    }

    // 二叉树的前序遍历   递归实现
    public static void list(BinaryNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.value);
        list(root.left);
        list(root.right);

    }


    // 找出链表中的倒数第 k个节点对应的值
    public static Integer get(Node<Integer> root, int k) {

        Integer[] array = new Integer[k];

        boolean flag = false;

        int idx = 0;
        while (root.getNext() != null) {
            Node<Integer> next = root.getNext();
            Integer value = next.getValue();

            if (idx < k) {
                array[idx++] = value;
            } else {
                Integer[] newArray = new Integer[k];
                System.arraycopy(array, 1, newArray, 0, k - 1);
                array = newArray;
                array[array.length - 1] = value;
                flag = true;
            }
            root = next;
        }

        return flag ? array[0] : -1;

    }

}
