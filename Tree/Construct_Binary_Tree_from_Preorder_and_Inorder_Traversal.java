/*
105. Construct Binary Tree from Preorder and Inorder Traversal
--------------------------------------------------------------
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder 
is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

*/

class Solution {
    int idx;
    HashMap<Integer,Integer> map;
    
    TreeNode buildTree(int[] preorder,int start,int end){
        if(start>end)
            return null;
        
        TreeNode root=new TreeNode(preorder[idx++]);
        root.left=buildTree(preorder,start,map.get(root.val)-1);
        root.right=buildTree(preorder,map.get(root.val)+1,end);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx=0;
        //Map-> val,idx
        //Inorder
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return buildTree(preorder, 0, preorder.length - 1);
    }
}
