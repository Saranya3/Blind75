/*
102. Binary Tree Level Order Traversal
---------------------------------------
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []


*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
            return res;
        q.add(root);
        TreeNode cur;
        int size;
        
        while(!q.isEmpty()){
            
            List<Integer> tmp=new ArrayList<>();
            size=q.size();
            while(size-->0){
                cur=q.poll(); 
                tmp.add(cur.val);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            res.add(tmp);
        }
        
        return res;
    }
}
