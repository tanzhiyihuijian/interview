package cn.com.dom4j.adt.tree;

import java.util.*;

public class TreeUtil {

    @SafeVarargs
    public static <AnyType> BinaryNode<AnyType> createBinaryTree(AnyType... array) {

        List<BinaryNode<AnyType>> nodeList = new ArrayList<>();

        for (AnyType a : array) {
            nodeList.add(new BinaryNode<>(a));
        }

        int length = array.length;

        for (int i = 0; i < length / 2; i++) {
            // 左孩子
            nodeList.get(i).setLeft(nodeList.get(i * 2 + 1));

            if (i != length / 2 - 1 || length % 2 == 1) {
                // 右孩子
                nodeList.get(i).setRight(nodeList.get(i * 2 + 2));
            }
        }

        return nodeList.get(0);
    }

    /**
     * 访问节点 (打印节点)
     */
    public static <AnyType> void printNodeValue(BinaryNode<AnyType> node) {
        System.out.print(node.getValue() + " ");
    }


    /**
     * 层序遍历 (广度优先遍历)
     */
    public static <AnyType> void layerOrder(BinaryNode<AnyType> root) {

        Queue<BinaryNode<AnyType>> queue = new LinkedList<>();

        // 从根节点入队列
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            // 取出队列首节点
            BinaryNode<AnyType> node = queue.poll();
            printNodeValue(node);
            if (node.getLeft() != null) {
                // 左节点入队列
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                // 右节点入队列
                queue.offer(node.getRight());
            }
        }
    }


    /**
     * 前序遍历 递归实现
     */
    public static <AnyType> void preOrderByRecursion(BinaryNode<AnyType> node) {
        if (node == null)
            return;
        System.out.print(node.getValue() + " ");
        preOrderByRecursion(node.getLeft());
        preOrderByRecursion(node.getRight());
    }

    /**
     * 中序遍历 递归实现
     */
    public static <AnyType> void inOrderByRecursion(BinaryNode<AnyType> node) {
        if (node == null)
            return;
        inOrderByRecursion(node.getLeft());
        printNodeValue(node);
        inOrderByRecursion(node.getRight());
    }

    /**
     * 后续遍历 递归实现
     */
    public static <AnyType> void postOrderByRecursion(BinaryNode<AnyType> node) {
        if (node == null)
            return;
        postOrderByRecursion(node.getLeft());
        postOrderByRecursion(node.getRight());
        printNodeValue(node);
    }

    /**
     * 前序遍历, 非递归实现
     * 1. 先入栈根节点, 打印其值, 再先后入栈右节点,左节点
     * 2. 出栈左节点, 打印其值, 再入栈该左节点的右节点,左节点, 直到遍历完该左节点所在子树
     * 3. 再出栈右节点, 打印其值, 再入栈该右节点的右节点,左节点, 直到遍历完该右节点所在子树
     */
    public static <AnyType> void preOrderByNoRecursion(BinaryNode<AnyType> node) {

        Stack<BinaryNode<AnyType>> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }

        while (!stack.empty()) {
            BinaryNode<AnyType> n = stack.pop();
            printNodeValue(n);
            if (n.getRight() != null) {
                stack.push(n.getRight());
            }
            if (n.getLeft() != null) {
                stack.push(n.getLeft());
            }
        }

    }


    /**
     * 中序遍历 非递归实现
     */
    public static <AnyType> void inOrderByNoRecursion(BinaryNode<AnyType> node) {

        Stack<BinaryNode<AnyType>> stack = new Stack<>();

        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.empty()) {
                node = stack.pop();
                printNodeValue(node);
                node = node.getRight();
            }
        }
    }







}
