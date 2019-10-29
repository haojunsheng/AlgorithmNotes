package com.code.tree;

/**
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重新构造出该二叉树。假设输入的前序遍历和中序遍历的结果中不包含重复的数字。例如输入的前序遍历序列为｛1，2，4，7，3，5，6，8｝和中序遍历为{4,7,2,1,5,3,6,8},则重建出二叉树并输出它的头结点。
 *
 * 在二叉树的前序遍历序列中，第一个数字总是树的根节点的值。但在中序遍历中，根节点的值在序列的中间，左子树的结点的值位于根节点的值的左边，而右子树的结点的值位于根节点的右边。因此我们需要扫描中序遍历序列，才能找到根节点的值。
 *
 * 如图所示，前序遍历序列的第一个数字1就是根节点的值。扫描中序遍历序列，就能确定根节点的值的位置。根据中序遍历的特点，在根节点的值1前面3个数字都是左子树结点的值，位于1后面的数字都是右子树结点的值。
 *
 * 解题思路：
 * 由于中序遍历序列中，有3个数字是左子树结点的值，因此左子树总共有3个左子结点。
 * 同样，在前序遍历的序列中，根节点后面的3个数字就是3个左子树结点的值，再后面的所有数字都是右子树结点的值。
 * 这样我们就在前序遍历和中序遍历两个序列中，分别找到了左右子树对应的子序列。
 * 既然我们已经分别找到了左、右子树的前序遍历序列和中序遍历序列，我们可以用同样的方法分别去构建左右子树。
 * 也就是说，接下来的事情可以用递归的方法去完成。
 */
public class ConstructBinaryTree_07 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++){
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // 二叉树的先序序列
        int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        // 二叉树的中序序列
        int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        printPostOrder(root); // 后序打印二叉树
    }

    /**
     * 后序遍历二叉树（递归实现）
     */
    public static void printPostOrder(TreeNode root) {
        if (root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.println(root.val);
        }
    }
}
