/*
371. Sum of Two Integers
-------------------------
Given two integers a and b, return the sum of the two integers without using the operators + and -. 

Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = 2, b = 3
Output: 5

*/

class Solution {
    public int getSum(int a, int b) {
        int carry=0;
        while(b!=0){
            carry=a&b;
            a=a^b;
            b=carry<<1;
            
        }
        return a;
    }
}
