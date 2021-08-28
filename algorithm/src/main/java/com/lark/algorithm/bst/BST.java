package com.lark.algorithm.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author btmood
 * @date 2021-08-14 19:14
 * @Description 二分搜索树，extends Comparable<E>表明元素必须具有可比较性
 *              不包含重复元素
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新元素e
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 向以Node为根的二分搜索树中插入元素E，递归算法
     * @param node
     * @param e
     */
//    private void add(Node node, E e) {
//        //递归的终止条件
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        //再次递归
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }

    /**
     * 递归代码优化：返回插入新节点后二分搜索书的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {
        /**
         * 最小问题
         * 可以把null也理解为一颗二叉树，那么二叉树分解到最小问题，肯定就是一颗null树
         */
        if (node == null) {
            size++;
            return new Node(e);
        }
        /**
         * 分解问题
         * 注意add()方法的宏观语义：添加新节点，并返回二叉树的根，那么我们只需要直接调用add()方法即可，不需要考虑微观实现
         */
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归算法：判断以node为根的二分搜索树中是否存在元素e
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     * 根左右
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 递归算法：前序遍历以node为根的二分搜索树
     * @param node
     */
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 注意这个方法和上面方法的区别
     * 递归算法也是可以不按照1.终止条件；2.分解方式；这两个步骤来写的
     * 两种写法可以体会下
     */
//    public void preOrder(Node node) {
//        if (node != null) {
//            System.out.println(node.e);
//            preOrder(node.left);
//            preOrder(node.right);
//        }
//    }

    /**
     * 深度优先遍历：前序遍历的非递归实现
     * 参考系统栈的调用
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            System.out.println(popNode.e);
            //由于栈是先进后出的，所以先把右子树压入栈
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     * 左根右
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 递归算法：中序遍历以node为根的二分搜索树
     * 其实前序、中序、后续主要看的是输出方式，所以改变根节点的输出时机，就能表示不同的遍历方式
     * @param node
     */
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * TODO
     * 中序遍历非递归实现
     * @param node
     */
    public void inOrderNR(Node node) {

    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 递归算法：后续遍历以node为根的二分搜索树
     * @param node
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * TODO
     * 后序遍历的非递归实现
     * @param node
     */
    public void postOrderNR(Node node) {

    }

    /**
     * 广度优先遍历：二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * 因为BST的最小值在树的最左边，所以一路遍历下去就可以了，类似一个链表
     * @param node
     * @return
     */
    public Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * TODO：非递归实现
     * @param node
     * @return
     */
    public Node minimumNR(Node node) {
        return null;
    }

    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E max() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return max(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * 因为BST的最大值在树的最左边，所以一路遍历下去就可以了，类似一个链表
     * @param node
     * @return
     */
    public Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    /**
     * TODO：非递归实现
     * @param node
     * @return
     */
    public Node maxNR(Node node) {
        return null;
    }

    /**
     * 从二叉树中删除最小值所在节点，并返回最小值
     * @return
     */
    public E removeMin() {
        //最小值
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    public Node removeMin(Node node) {
        if (node.left == null) {
            //如果右节点有元素，就把右节点返回，作为node上层节点的左子树
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二叉树中删除最小值所在节点，并返回最小值
     * @return
     */
    public E removeMax() {
        //最小值
        E ret = max();
        root = removeMax(root);
        return ret;
    }

    /**
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    public Node removeMax(Node node) {
        if (node.right == null) {
            //如果右节点有元素，就把右节点返回，作为node上层节点的左子树
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    public void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
