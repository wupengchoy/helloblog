package com.wupengchoy.mystudy.datastructure.tree;

/**
 * AVL数--带有平衡条件的二叉查找树
 */
public class MyAvlTree<T extends Comparable<? super T>> {
    private class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        public AvlNode(T t) {
            this(t, null, null);
        }

        public AvlNode(T t, AvlNode<T> left, AvlNode<T> right) {
            this.element = t;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    private AvlNode<T> root;

    /**
     * 插入与普通二叉树插入类似，在最后加上平衡的逻辑
     */
    public void insert(T t) {
        this.insert(t, this.root);
    }

    private AvlNode<T> insert(T t, AvlNode<T> node) {
        if (node == null) return new AvlNode<>(t);
        int compareRsult = t.compareTo(node.element);
        if (compareRsult > 0) {
            node.right = insert(t, node.right);
        } else if (compareRsult < 0) {
            node.left = insert(t, node.left);
        } else {
            //存在相同元素 do nothing
        }
        return balance(node);
    }

    /**
     * 1.左子树长，且左子树的left长-->单右旋
     * 2.左子树长，且左子树的right长-->双旋(子树左旋，节点右旋)
     * 3.右子树长，且右子树的right长-->单左旋
     * 4.右子树长，且右子树的left长-->双旋(子树右旋，节点左旋)
     */
    private static final int ALLOW_IMBALANCE = 1;

    private AvlNode<T> balance(AvlNode<T> node) {
        if (node == null) return null;
        //左子树高
        if (height(node.left) - height(node.right) > ALLOW_IMBALANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                //左子树单旋
                node = rotateWithLeftChild(node);
            } else {
                //左子树双旋
                node = doubleRotateWithLeftChild(node);
            }
        }//右子树高
        else if (height(node.left) - height(node.right) < ALLOW_IMBALANCE) {
            if (height(node.right.left) <= height(node.right.right)) {
                //右子树单旋
                node = rotateWithRightChild(node);
            } else {
                //右子树双旋
                node = doubleRotateWithRightChild(node);
            }
        }
        //insert方法中如果不平衡了，肯定是因为插入了一个节点，旋转的下一个节点此时的height是0，旋转后需要+1--递归叠加
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node) {
        AvlNode<T> top = node.left;
        node.left = top.right;
        top.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        top.height = Math.max(height(top.left), node.height) + 1;
        return top;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> node) {
        AvlNode<T> top = node.right;
        node.right = top.left;
        top.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        top.height = Math.max(height(top.right), node.height) + 1;
        return top;
    }

    private AvlNode<T> doubleRotateWithLeftChild(AvlNode<T> node) {
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    private AvlNode<T> doubleRotateWithRightChild(AvlNode<T> node) {
        node.right = rotateWithLeftChild(node.left);
        return rotateWithRightChild(node);
    }

    private int height(AvlNode<T> node) {
        return node == null ? -1 : node.height;
    }
}
