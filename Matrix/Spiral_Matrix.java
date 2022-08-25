/*
54. Spiral Matrix
-----------------
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res=new ArrayList<>();
        int r=0,c=0,row=matrix.length-1,col=matrix[0].length-1;
        
        while(r<=row && c<=col){
            for(int i=c;i<=col;i++){
                res.add(matrix[r][i]);
            }
            r++;
            for(int i=r;i<=row;i++){
                res.add(matrix[i][col]);
            }
            col--;
            if(r<=row){
                for(int i=col;i>=c;i--){
                    res.add(matrix[row][i]);
                }
                row--;
            }
            if(c<=col){
               for(int i=row;i>=r;i--){
                   res.add(matrix[i][c]);
               }
               c++;
            }
            
        }
        
        return res;
        
    }
}
