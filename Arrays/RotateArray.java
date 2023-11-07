 /** Problem Statement 
 Given an array of integers arr[] of size N and an integer, the task is to rotate the array elements
 to the left by 'k' positions. where k is non -ve
Input: 
arr[] = {1, 2, 3, 4, 5, 6, 7}, k = 2
Output: 3 4 5 6 7 1 2

Input: arr[] = {3, 4, 5, 6, 7, 1, 2}, d=2
Output: 5 6 7 1 2 3 4   
**/

import java.io.*;
import java.util.* ;

public class Solution {

// Solution 1 - store and shift
public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int[] temp = new int[k];
        for(int i=0; i<k; i++) {
            temp[i] = arr.get(i);
        }

        // shifting the n-k elements to left
        for(int i=k; i<arr.size(); i++) {
            arr.set(i-k, arr.get(i));
        }

        // copying the remaining 'k' elements in sequence 
        // from the temp array
        for(int i=0; i<k; i++) {
            arr.set(i+arr.size()-k, temp[i]);
        }

        return arr;
    }

// Time - O(n) for traversing all arrays in a single way 
// Space - O(k) for temp array





// Approach 2 - rotation by reversal
public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        
        int n = arr.size();
        k = k % n;
        
        // reverse the complete array k=2
        reverse(arr,0,n); // 1 2 3 4 5 --> 5 4 3 2 1
        // reverse the n-k elements so that they maintain the correct order 
        // and are shifted
        reverse(arr, 0, n-k); // ( 3 4 5 ) 2 1  
        // arrange the k-elements at the end in order as left-rotation by 'k' means
        // the initial k elements will shift towards the end
        reverse(arr, n-k, n); // 3 4 5 1 2
        return arr;
    }



    // reverse the array till mid 
    private static void reverse(ArrayList<Integer> arr, int l, int r) {
        int mid = (r - l)/2;
        int i=0;
        while( i<mid ) {
            int temp = arr.get(l+i);
            arr.set(l+i, arr.get(r-i-1));
            arr.set(r-i-1,temp);
            i++;
        }
    }

    // Time complexity - O(n)
    // Space complexity - O(1) 

}
