package cn.com.dom4j.adt.tree;

import org.junit.Test;

import java.util.Stack;

public class TestDemo {

    public static void main(String[] args) {

    }

    @Test
    public void f1() {

//        BinaryNode root = TreeUtil.createBinaryTree(1, 2, 3);

        BinaryNode<String> root = TreeUtil.createBinaryTree("A", "B", "C", "D");


//        BinaryNode root = new BinaryNode(1, new BinaryNode(2, new BinaryNode(4, new BinaryNode(8), null), new BinaryNode(5)), new BinaryNode(3, new BinaryNode(6), new BinaryNode(7)));


        System.out.print("二叉树层序遍历: ");
        TreeUtil.layerOrder(root);
        System.out.println();

        System.out.print("二叉树前序遍历(递归实现): ");
        TreeUtil.preOrderByRecursion(root);
        System.out.println();

        System.out.print("二叉树前序遍历(非递归实现): ");
        TreeUtil.preOrderByNoRecursion(root);
        System.out.println();

        System.out.print("二叉树中序遍历(递归实现): ");
        TreeUtil.inOrderByRecursion(root);
        System.out.println();

        System.out.print("二叉树中序遍历(非递归实现): ");
        TreeUtil.inOrderByNoRecursion(root);
        System.out.println();

        System.out.print("二叉树后序遍历(递归实现): ");
        TreeUtil.postOrderByRecursion(root);
        System.out.println();




    }














}
