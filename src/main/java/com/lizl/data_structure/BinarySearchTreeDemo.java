package com.lizl.data_structure;

/**
 * 二叉搜索树 demo
 *
 * @author lizl
 * @date 2018/9/6 11:35
 */
public class BinarySearchTreeDemo {

    private BsNode root = null;

    /**
     * 节点类
     */
    public class BsNode{
        BsNode parent;
        BsNode left;
        BsNode right;
        int hash;
        Object data;

        public BsNode(BsNode parent, BsNode left, BsNode right, int hash, Object data) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.hash = hash;
            this.data = data;
        }
    }

    /**
     * 插入
     * @param x
     */
    public void insert(BsNode x){
        BsNode y = null;
        BsNode tmp = root;

        while (tmp != null){
            y = tmp;
            if (x.hash < tmp.hash){
                tmp = tmp.left;
            }else {
                tmp = tmp.right;
            }
        }

        x.parent = y;

        if(null == y){
            root = x;
        }else if(x.hash < y.hash){
            y.left = x;
        }else {
            y.right = x;
        }
    }

    public void biSortTree(int[] arr,int n){
        for(int i=0;i<n;i++){
            BsNode node = new BsNode(null, null ,null, arr[i],null);
            insert(node);
        }
    }

    /**
     * 根据hash 查找元素，找到返回节点 找不到返回null
     * @param hash
     * @return
     */
    public BsNode find(int hash){
        BsNode tmp = root;
        while (tmp !=null){
            if(tmp.hash < hash){
                tmp = tmp.right;
            }else if(tmp.hash > hash){
                tmp = tmp.left;
            }else {
                return tmp;
            }
        }
        return null;
    }

    /**
     * 查找最小关键字 即最左结点，需要传入查找根节点
     * @param root
     * @return
     */
    public BsNode findMinNode(BsNode root){
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }

    /**
     * 查找最大关键字 即最右结点，需要传入查找根节点
     * @param root
     * @return
     */
    public BsNode findMaxNode(BsNode root){
        while (root.right!=null){
            root = root.right;
        }
        return root;
    }

    /**
     * 查找后继
     * @param hash
     * @return
     */
    public BsNode findFollowNode(int hash){
        BsNode node = find(hash);
        if(node == null){
            return null;
        }
        BsNode p = null;
        if(node.right != null){
            return findMinNode(node.right);
        }else {
            p = node.parent;

            while(p != null && node == p.right){
                node = p;
                p = p.parent;
            }
                return p;
        }
    }
}
