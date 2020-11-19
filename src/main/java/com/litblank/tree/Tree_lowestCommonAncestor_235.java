package com.litblank.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 235. 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 *
 * 说明:
 *
 *     所有节点的值都是唯一的。
 *     p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: Tree_lowestCommonAncestor_235
 * @Author: chenyadong
 * @Date: 2020/9/27 17:01
 */
public class Tree_lowestCommonAncestor_235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList=new ArrayList<>();
        List<TreeNode> qList=new ArrayList<>();
        DFS_1(root,p,pList);
        if(q!=null){
            DFS_1(root,q,qList);
        }
        if(q!=null){
            int qi=qList.size()-1;
            TreeNode treeNode=null;
            for (int i = pList.size()-1; i >=0 && qi>=0; i--) {
                if(pList.get(i).val==qList.get(qi--).val){
                    treeNode=pList.get(i);
                }else{
                    break;
                }
            }
            return treeNode;
        }else{
            return pList.get(0);
        }
    }


    private boolean DFS_1(TreeNode root, TreeNode p,List<TreeNode> pList){
        if(root.val==p.val){
            pList.add(root);
            return true;
        }
        if(root.left!=null){
            if(pList.size()==0 && DFS_1(root.left,p,pList)){
                pList.add(root);
                return true;
            }
        }
        if(root.right!=null){
            if(pList.size()==0 && DFS_1(root.right,p,pList)){
                pList.add(root);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Tree_lowestCommonAncestor_235.TreeNode treeNode1=new Tree_lowestCommonAncestor_235().new TreeNode(6);
        Tree_lowestCommonAncestor_235.TreeNode treeNode2=new Tree_lowestCommonAncestor_235().new TreeNode(2);
        Tree_lowestCommonAncestor_235.TreeNode treeNode3=new Tree_lowestCommonAncestor_235().new TreeNode(8);
        Tree_lowestCommonAncestor_235.TreeNode treeNode4=new Tree_lowestCommonAncestor_235().new TreeNode(0);
        Tree_lowestCommonAncestor_235.TreeNode treeNode5=new Tree_lowestCommonAncestor_235().new TreeNode(4);
        Tree_lowestCommonAncestor_235.TreeNode treeNode6=new Tree_lowestCommonAncestor_235().new TreeNode(7);
        Tree_lowestCommonAncestor_235.TreeNode treeNode7=new Tree_lowestCommonAncestor_235().new TreeNode(9);
        Tree_lowestCommonAncestor_235.TreeNode treeNode8=new Tree_lowestCommonAncestor_235().new TreeNode(3);
        Tree_lowestCommonAncestor_235.TreeNode treeNode9=new Tree_lowestCommonAncestor_235().new TreeNode(5);
        treeNode1.left=treeNode2;
//        treeNode1.right=treeNode3;
//        treeNode2.left=treeNode4;
//        treeNode2.right=treeNode5;
//        treeNode5.left=treeNode8;
//        treeNode5.right=treeNode9;
//        treeNode3.left=treeNode6;
//        treeNode3.right=treeNode7;

        System.out.println(JSON.toJSONString(new Tree_lowestCommonAncestor_235().lowestCommonAncestor(treeNode1,treeNode2,treeNode1).val));
    }

}
