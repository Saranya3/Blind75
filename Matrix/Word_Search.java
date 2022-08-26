/*
79. Word Search
---------------
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or 
vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

*/

class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0))
                        return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board,String word,int r,int c,int idx){
        
        if(idx==word.length())
            return true; 
        
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]!=word.charAt(idx))
            return false;
        
        board[r][c]='*';
        
        boolean res=dfs(board,word,r-1,c,idx+1)||dfs(board,word,r+1,c,idx+1)||dfs(board,word,r,c-1,idx
+1)||dfs(board,word,r,c+1,idx+1);
        board[r][c] = word.charAt(idx);
        return res;
        
    }
    
}
