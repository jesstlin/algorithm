package com.leetcode.medium;
//114. Flatten Binary Tree to Linked List

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FlattenTree {
    
    public void flatten(TreeNode node) {
        if (node == null)
            return;
        if( node.right ==null && node.left == null )
            return;
        
        
        if( node.left != null){
            flatten(node.left);
            
            TreeNode tmp =  node.right;
            node.right = node.left;
            node.left = null;

            //insert right
            TreeNode curr = node.right;
            while(curr.right !=null){
                curr = curr.right;
            }
            curr.right = tmp;
            
        }
        flatten(node.right);
    }
    
}
