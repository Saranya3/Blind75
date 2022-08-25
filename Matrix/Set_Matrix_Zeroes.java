/*
73. Set Matrix Zeroes
---------------------
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

*/

class Solution {
    public void setZeroes(int[][] matrix) {
        //Store row & col
        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();
        int r=matrix.length,c=matrix[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int i:row){
            for(int j=0;j<c;j++){
                matrix[i][j]=0;
            }
        }
        
        for(int j:col){
            for(int i=0;i<r;i++){
                matrix[i][j]=0;
            }
        }
        
    }
}
