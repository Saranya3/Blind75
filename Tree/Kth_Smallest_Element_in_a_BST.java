/*
230. Kth Smallest Element in a BST
-----------------------------------
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

*/

//1
class Solution {
    int ctr,res;
    void lnr(TreeNode root,int k){
        if(root==null)
            return;
        lnr(root.left,k);
        if(ctr==k){
            res=root.val;
        }
        ctr++;
        lnr(root.right,k);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        ctr=1;
        res=-1;
        lnr(root,k);
        return res;
    }
}

//2
class Solution {
  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    return arr;
  }

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }
}
