package com.lark.algorithm.map;

import com.lark.algorithm.bst.BST;

/**
 * @author btmood
 * @date 2021-08-30 20:19
 * @Description key是需要能比较的
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 递归代码优化：返回插入新节点后二分搜索书的根
     * @param node
     * @return
     */
    private Node add(Node node, K key, V value) {
        /**
         * 最小问题
         * 可以把null也理解为一颗二叉树，那么二叉树分解到最小问题，肯定就是一颗null树
         */
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        /**
         * 分解问题
         * 注意add()方法的宏观语义：添加新节点，并返回二叉树的根，那么我们只需要直接调用add()方法即可，不需要考虑微观实现
         */
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
             //key.compareTo(node.key) == 0的情况，就把key对应的value进行修改
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    /**
     * 递归：返回删除节点后新的二分搜索树的根
     * @param node
     * @param key
     * @return
     */
    public Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            /**
             * 当e==node.e时又要分为三种情况考虑
             * 1. 待删除节点左子树为空
             * 2. 待删除节点右子树为空
             * 3. 待删除节点左右子树都不为空
             */
            //1. 待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //2. 待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            /**
             * 3. 待删除节点左右子树都不为空
             * 找到比待删除节点大的最小节点，即为待删除节点右子树的最小节点
             * 用这个节点顶替待删除节点的位置
             */
            Node successor = minimum(node.right);
            //注意这里虽然删除了元素但是并不需要size--，因为removeMin()这个方法已经减过了
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;

            return successor;
        }
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

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.left, key);
        }

    }
}
