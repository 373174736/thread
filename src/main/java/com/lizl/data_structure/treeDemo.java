package com.lizl.data_structure;

public class treeDemo {
    public static void main(String[] args) {
        Node root = new Node("A");

        Node l11 = new Node("B");
        Node l12 = new Node("C");
        Node l21 = new Node("D");
        Node l22 = new Node("E");
        Node l23 = new Node("F");
        Node l24 = new Node("G");

        root.setLeft(l11);
        root.setRight(l12);

        l11.setLeft(l21);
        l11.setRight(l22);
        l12.setLeft(l23);
        l12.setRight(l24);


//        preOrderTraverse(root);//前序遍历
//        inOrderTraverse(root);//中序遍历
        postOrderTraverse(root);//后序遍历
    }

    /**
     * 前序遍历二叉树
     * @param root
     */
    static void preOrderTraverse(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.getData());
        preOrderTraverse(root.getLeft());
        preOrderTraverse(root.getRight());
    }

    /**
     * 中序遍历二叉树
     * @param root
     */
    static void inOrderTraverse(Node root){
        if(root == null){
            return;
        }
        preOrderTraverse(root.getLeft());
        System.out.println(root.getData());
        preOrderTraverse(root.getRight());
    }

    /**
     * 后序遍历二叉树
     * @param root
     */
    static void postOrderTraverse(Node root){
        if(root == null){
            return;
        }
        preOrderTraverse(root.getLeft());
        preOrderTraverse(root.getRight());
        System.out.println(root.getData());
    }





    static class Node{
        String Data;
        Node left;
        Node right;

        public Node(String data) {
            Data = data;
        }

        public String getData() {
            return Data;
        }

        public void setData(String data) {
            Data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
