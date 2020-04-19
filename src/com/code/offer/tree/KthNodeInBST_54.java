package com.code.offer.tree;

public class KthNodeInBST_54 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int count = 0;

    /**
     * 如果没有if(node != null)这句话
     * 那么那个root就是返回给上一级的父结点的，而不是递归结束的条件了,
     * 有了这句话过后，一旦返回了root，那么node就不会为空了，就一直一层层的递归出去到结束了。
     * 举第一个例子{8,6,5,7,},1 答案应该是5，
     * 如果不加的时候，开始，root=8，node=kth（6,1），
     * 继续root=6，node=kth（5,1）root =5 返回null，
     * 这时向下执行index=k=1了，返回 5给root=6递归的时候的node，
     * 这时回到root=8了，往后面调右孩子的时候为空而把5给覆盖了。
     * 现在就为空了，有了这句话后虽然为空，但不把null返回，而是继续返回5。
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        TreeNode temp = null;
        temp = KthNode(pRoot.left, k);
        if (temp != null) {
            return temp;
        }
        if (++count == k) {
            return pRoot;
        }
        temp = KthNode(pRoot.right, k);
        if (temp != null) {
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode temp2 = new TreeNode(2);
        TreeNode temp3 = new TreeNode(3);
        TreeNode temp4 = new TreeNode(4);
        TreeNode temp5 = new TreeNode(5);
        TreeNode temp6 = new TreeNode(6);
        TreeNode temp7 = new TreeNode(7);
        TreeNode temp8 = new TreeNode(8);

        temp5.left = temp3;
        temp5.right = temp7;
        temp3.left = temp2;
        temp3.right = temp4;
        temp7.left = temp6;
        temp7.right = temp8;
        KthNodeInBST_54 node = new KthNodeInBST_54();
        node.KthNode(temp5, 3);
    }
}
