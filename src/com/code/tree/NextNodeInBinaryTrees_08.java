package com.code.tree;

/**
 * 仔细观察，可以把中序下一结点归为几种类型：
 *
 * 有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
 *
 * 无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
 *
 * 无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点
 */
public class NextNodeInBinaryTrees_08 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNextNode(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }
        if(pNode.right!=null){//如果有右子树，则找右子树的最左节点
            pNode=pNode.right;
            while(pNode.left!=null)
                pNode=pNode.left;
            return pNode;
        }else{
            while(pNode.next!=null){//没右子树，则找第一个当前节点是父节点左孩子的节点
                if(pNode.next.left==pNode)
                    return pNode.next;
                pNode=pNode.next;
            }
        }
        return null;//退到了根节点仍没找到，则返回null
    }

    //创建一颗空树
    private TreeLinkNode createTree(int val){
        TreeLinkNode node=new TreeLinkNode(val);
        node.left=null;
        node.right=null;
        node.next=null;
        return node;
    }

    private void connectTree(TreeLinkNode parent,TreeLinkNode left,TreeLinkNode right){
        if(parent!=null){
            parent.left=left;
            parent.right=right;
        }
        if(left!=null){
            left.next=parent;
        }
        if(right!=null){
            right.next=parent;
        }
    }

    public static void main(String[] args){

    }
}