/*
572. Subtree of Another Tree
----------------------------
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same 
structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
*/

class Solution {
    boolean helper(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null)
            return true;
        if(root==null || subRoot==null)
            return false;
        return root.val==subRoot.val && helper(root.left,subRoot.left) && helper(root.right,subRoot.right);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
            return true;
        
         if(root==null || subRoot==null)
            return false;
        boolean flag=false;
        if(root.val==subRoot.val)
            flag=helper(root.left,subRoot.left) && helper(root.right,subRoot.right);
        
        
        return flag || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
