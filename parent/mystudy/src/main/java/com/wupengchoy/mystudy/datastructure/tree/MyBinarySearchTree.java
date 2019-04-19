package com.wupengchoy.mystudy.datastructure.tree;

public class MyBinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T> {
        //父节点
        T element;
        //左子节点
        BinaryNode<T> left;
        //右子节点
        BinaryNode<T> right;

        public BinaryNode(T e) {
            this(e, null, null);
        }

        public BinaryNode(T e, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = e;
            this.left = left;
            this.right = right;
        }
    }

    //根节点
    BinaryNode<T> root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    //contains
    public boolean contains(T t) {
        return contains(t, root);
    }

    public boolean contains(T t, BinaryNode<T> node) {

        if (node == null) return false;
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            return contains(t, node.left);
        } else if (compareResult > 0) {
            return contains(t, node.right);
        } else {
            return true;
        }
    }

    //查找最大值最小值--使用递归或者非递归方式都可以
    public T findMax() {
        if (this.root == null) return null;
        //递归
        return findMax(this.root);
    }

    private T findMax(BinaryNode<T> node) {
        if (node.right == null) {
            return node.element;
        } else {
            return findMax(node.right);
        }
    }

    public T findMin() {
        return findMin(this.root);
    }

    public T findMin(BinaryNode<T> node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }

    //插入
    public void insert(T t) {
        this.root = insert(t, this.root);
    }

    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        //第一次插入的时候root为空
        if (node == null) return new BinaryNode<>(t, null, null);
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {//左子树
            node.left = insert(t, node.left);
        } else if (compareResult > 0) {//右子树
            node.right = insert(t, node.right);
        } else {
            //元素存在，不操作或者更新
        }
        return node;
    }

    /**
     * 删除
     * 原理：分单双节点，如果当前删除节点只有一个子节点，则直接删除当前节点，并将子节点放到当前节点的位置上
     * 如果有删除的节点有两个子节点，则删除当前节点，并将右子节点的最小节点替换到当前删除节点，并删除右子节点的最小节点
     * ，原因是因为右子节点的最小值以为都大于最小节点，放在最右侧
     */
    public void remove(T t) {
        remove(t, this.root);
    }

    public BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null) return null;
        int compareResult = t.compareTo(node.element);
        if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (node.left != null && node.right != null)//two subNode
        {
            //查找最小值替换，并删除最小值--最小值没有左子节点
            node.element = findMin(node);
            //删除右子树的最小值的T--已经替换到当前位置
            node.right = remove(node.element,node.right);
        } else//one subNode
        {
            node = node.left!=null?node.left:node.right;
        }
        return node;
    }
}