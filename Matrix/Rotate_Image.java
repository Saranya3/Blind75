/*
48. Rotate Image
----------------
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

*/

class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        
        //Transpose
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(r<c){
                    int tmp=matrix[r][c];
                    matrix[r][c]=matrix[c][r];
                    matrix[c][r]=tmp;
                }
            }
        }
        
        //Swaps within row
        
        for(int r=0;r<row;r++){
            for(int c=0;c<col/2;c++){
                int tmp=matrix[r][c];
                matrix[r][c]=matrix[r][col-c-1];
                matrix[r][col-c-1]=tmp;
            }
        }
    }
}
