package com.lizl.data_structure;

/**
 * 红黑树 demo
 *
 * @author lizl
 * @date 2018/9/6 11:35
 */
public class RBTreeDemo {

    private BsNode root = null;
    private BsNode nil = null;
    private static final boolean RED = true;
    private static final boolean BLACK = true;

    /**
     * 节点类
     */
    public class BsNode{
        BsNode parent;
        BsNode left;
        BsNode right;
        int hash;
        Object data;
        boolean color;

        public BsNode(BsNode parent, BsNode left, BsNode right, int hash, Object data, boolean color) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.hash = hash;
            this.data = data;
            this.color = color;
        }
    }

    /**
     * 左旋节点
     * @param x
     */
    public void leftRotate(BsNode x){
        BsNode y = x.right;
        //设置x的右节点为y的左节点，因为一会y的左节点 就变成 x了。
        x.right = y.left;
        //如果y的left 不为空 需要将y的left的parent 设置为 x
        if(y.left != null){
            y.left.parent = x;
        }
        //如果一个节点的双亲节点为空，则这个节点就是根节点
        if(x.parent == null){
            root = y;
        }else if(x == x.parent.left){
            //判断x 是不是x双亲的左孩子 ，如果是 将x双亲的左孩子 指向y
            x.parent.left = y;
        }else {
            //x 是 x 双亲的右孩子， 将x双亲的右孩子 指向 y
            x.parent.right = y;
        }
        //y的左孩子为x
        y.left = x;
        //x的双亲为 y
        x.parent = y;
    }

    /**
     * 右旋节点
     * @param x
     */
    public void rightRotate(BsNode x){

        BsNode y = x.parent;

        y.left = x.right;

        if(x.right!= null){
            x.right.parent = y;
        }

        if(y.parent == null){
            root = x;
        }else if(y == y.parent.left){
            y.parent.left = x;
        }else {
            y.parent.right=x;
        }

        x.right = y;
        y.parent = x;
    }

    /**
     * 红黑树的插入
     * @param z
     */
    public void rbInsert(BsNode z){
        BsNode y = nil;

        BsNode x = root;
        //根据大小来判断 z的双亲节点是谁
        while (x != null){
            y = x;
            if(z.hash > x.hash){
                x = x.right;
            }else {
                x = x.left;
            }
        }
        //设置双亲节点
        z.parent = y;
        //如果y是null则 此树是空的。设置z为树的根节点。否则判断大小来确定是y的左孩子还是右孩子
        if(y == null){
            root = z;
        }else if (z.hash < y.hash){
            y.left = z;
        }else {
            y.right = z;
        }
        //设置左右孩子为null
        z.left = null;
        z.right = null;
        //设置颜色为红色
        z.color = RED;

    }

    /**
     * 插入节点会导致 破坏了红黑树的一些特性
     *
     * @param z
     */
    public void rbInsertFixUp(BsNode z){
        while (z.parent.color == RED){
            if(z.parent == z.parent.parent.left){
                BsNode y = z.parent.parent.right;
                if(y.color == RED){
                    //那么为了符合红黑树的特性，如果y是红色的 那么z.p.p一定是黑的
                    //z为红色 设置z的双亲 和叔叔为黑色，z的双亲的双亲为红色
                    //那么会有一个问题z的双亲的双亲的双亲，若果为红色还是破坏红黑树的特性，所以就需要递归一下
                    z.parent.parent.color = RED;
                    y.color = BLACK;
                    z.parent.color = BLACK;
                    z = z.parent.parent;
                }else if(z == z.parent.right){
                    z=z.parent;
                    leftRotate(z);
                }
                z.parent.color = BLACK;
                z.parent.parent.color = RED;
                rightRotate(z);
            }else {
                BsNode y = z.parent.parent.left;
                if(y.color == RED){
                    //那么为了符合红黑树的特性，如果y是红色的 那么z.p.p一定是黑的
                    //z为红色 设置z的双亲 和叔叔为黑色，z的双亲的双亲为红色
                    //那么会有一个问题z的双亲的双亲的双亲，若果为红色还是破坏红黑树的特性，所以就需要递归一下
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z=z.parent.parent;
                }else if(z== z.parent.left){
                    z=z.parent;
                    rightRotate(z);
                }
                z.parent.color = BLACK;
                z.parent.parent.color = RED;
                leftRotate(z);
            }
        }
        root.color = BLACK;
    }

}
