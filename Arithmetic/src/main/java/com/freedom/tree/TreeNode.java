package com.freedom.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


public class TreeNode {
    /**
     * 二叉树节点
     */
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data) {
        this.data = data;
    }

    /**
     * 构建二叉树
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     *
     * @param node 二叉树的节点
     */
    public static void preorderTraversal(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.data);
        preorderTraversal(node.leftChild);
        preorderTraversal(node.rightChild);
    }

    /**
     * 中序遍历
     */
    public static void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        inorderTraversal(node.leftChild);
        System.out.println(node.data);
        inorderTraversal(node.rightChild);

    }

    /**
     * 二叉树后续遍历
     *
     * @param node
     */
    public static void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.leftChild);
        postorderTraversal(node.rightChild);
        System.out.println(node.data);

    }

    /**
     * 二叉树的非递归前序遍历
     *
     * @param root
     */
    public static void preOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //若节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            while (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null,
                null, 10, null, null, 8, null, 4}));
        TreeNode tree = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preorderTraversal(tree);

        System.out.println("----------------------");
        System.out.println("中序遍历：");
        inorderTraversal(tree);

        System.out.println("----------------------");
        System.out.println("后序遍历：");
        postorderTraversal(tree);


    }

}
