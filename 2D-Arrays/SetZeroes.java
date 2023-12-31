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



    
public static void setZerosApproachTwo(int matrix[][]) {
        
        // 'n' rows
        int n = matrix.length;
        // 'm' columns
        int m = matrix[0].length;

        // a hashet to store the unique row indexes which are to be set to zero
        boolean[] rowSet = new boolean[n];

        // a hashet to store the unique column indexes which are to be set to zero
        boolean[] columnSet = new boolean[m];

        // set the rows and columns which are 0
        // Time - O(m * n)
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    rowSet[i] = true;
                    columnSet[j] = true;
                }
            }
        }

        // set all the rows to zero
        // Time - O(n * m)
        for(int i=0; i<rowSet.length; i++) {
            if(rowSet[i]) {
                // set entire row to 0
                for(int j = 0 ;j<m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set all column values to 0
        // Time - O( n * m)
        for(int i=0; i<columnSet.length; i++) {
            if(columnSet[i]) {
                // set entire column to 0
                for(int j = 0 ;j<n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }   
    }

    // Time complexity - O(m * n)
    // Space complexity - O(m + n)




    public static void setZerosOptimalSpace(int matrix[][]) {
        // 'n' rows
        int n = matrix.length;
        // 'm' columns
        int m = matrix[0].length;

        // boolean values for taking care of first column or row
        boolean firstCol = false;
        boolean firstRow = false;

        // instead of using external space for storing the rows and columns
        // we can set the first column and first row as 0 as that will always be set to zero
        // in future
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // if the element is zero,
                // set matrix[0][j] = 0  and matrix[i][0] = 0
                if(matrix[i][j] == 0) {
                    if(j == 0) {
                        firstCol = true;
                    }
                    if( i == 0) {
                        firstRow = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // once the row and column is set, the entire row and column needs to be set as zero
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                // if the corresponding row or the column is 0, it  is set to 0
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // if any of the values is 0 in the first row , set entire row as 0
        if(firstRow) {
            for(int k=0; k<m; k++) {
                matrix[0][k] = 0;
            }
        }


        // if any of the column values is 0. in first column, 
        // set the entire column as 0
        if( firstCol ) {
            for(int k=0; k<n; k++) {
                matrix[k][0] = 0;
            }
        }

    }

    // Time complexity - O(m * n)
    // Space complexity - O(1)
  

    

}
