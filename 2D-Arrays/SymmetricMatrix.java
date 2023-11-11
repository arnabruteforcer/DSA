/** Problem statement
The transpose of a matrix is found by interchanging its rows into columns or columns into rows. The transpose of the matrix is denoted by using
the letter “T” in the superscript of the given matrix. For example, if “A” is the given matrix, 
then the transpose of the matrix is represented by A' or AT  

Given a 2D matrix, check if it symmetric or nor. A matrix is said to be symmetric if A^T = A
**/  
  

import java.util.* ;
import java.io.*; 

public class Solution {
    public static boolean isMatrixSymmetric(int[][] arr) {
        
        int n = arr.length;
        
        // for the entire matrix compare the upper triangle on top of diagonal
        // with lower part 
        for(int i=0; i<n; i++) {
            // all columns with value i-1 has been verified before while
            // working on the previus row
            for(int j=i; j<n; j++) {
                 if(arr[i][j] != arr[j][i]) {
                     return false;
                 }   
            }
        }
        return true;
    }

    // Time complexity - O(n^2) - all elements in the array
    // Space complexity - O(1)
}
