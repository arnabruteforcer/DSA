/**

Given a Matrix arr of size N (rows) x M (columns), the task is to set all rows and columns for the given row and column to zeroes if a 
particular element is zero,

Example:
Input: [ 
[1, 1, 1],
[1, 0, 1],
[1, 1, 1]]

Output: [ 
[1, 0, 1],
[0, 0, 0],
[1, 0, 1]]

**/

import java.io.*;
import java.util.* ;

public class Solution {
    public static void setZeros(int matrix[][]) {
        
        // rows
        int n = matrix.length;
        // columns
        int m = matrix[0].length;

        int[][] temp = new int[n][m];

        // copy the matrix to a temporary array
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        // update the rows and columns which are required to be set to 0
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(temp[i][j] == 0) {
                    setZeroes(matrix,i,j,n,m);
                }
            }
        }
    }
  // Time complexity - O(m*n(m+n)) - O(m^2 + n^2 + m * n )
    // Space complexity - O(m * n)


    /**
        A private method for setting the zeroes for a given row and column
    **/
    private static void setZeroes(int[][] matrix, int row, int col, int rows, 
    int cols) {
        
        // set the entire row to zero 
        for(int i=0; i<cols; i++) {
            matrix[row][i] = 0;
        }

        // set the entire column to 0
        for(int i=0; i<rows; i++) {
            matrix[i][col] = 0;
        }

    }

  

    

}
