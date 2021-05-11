package com.leetcode.medium;
//109. Convert Sorted List to Binary Search Tree
//Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

//For this problem, a height-balanced binary tree is defined as a binary tree 
// in which the depth of the two subtrees of every node never differ by more than 1.

//Solution
// Traverse given BST in inorder and store result in an array. This step takes O(n) time. 
// Note that this array would be sorted as inorder traversal of BST always produces sorted sequence.

// Build a balanced BST from the above created sorted array using the recursive approach discussed here. 
// This step also takes O(n) time as we traverse every element exactly once and processing an element takes O(1) time.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
class SortedListToBSTree {
    TreeNode root;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode itr = head;
        ArrayList<Integer> store = new ArrayList();
        while(head != null){
            store.add(head.val);
            head = head.next;
        }
        root = buildBSTree(store, 0,  store.size()-1 );
        
        return root;    
        
    }
    
    TreeNode buildBSTree(ArrayList<Integer> nodes, int start, int end){
        
        if( start > end ){
            return null;
        }
        
        int mid = (start + end)/2;
        
        TreeNode curr = new TreeNode( nodes.get(mid));
        curr.right = buildBSTree( nodes, mid + 1, end);
        curr.left = buildBSTree( nodes, start, mid -1);
        return curr;
    }
}
