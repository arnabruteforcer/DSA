
/** Problem Statement
Given an array of integers, 
our task is to write a program that efficiently finds the second-largest element present in the array. 

Example:

Input: arr[] = {12, 35, 1, 10, 34, 1}
Output: The second largest element is 34.
Explanation: The largest element of the array is 35 and the second 
largest element is 34
  
Input: arr[] = {10, 5, 10}
Output: The second largest element is 5.
Explanation: The largest element of 
the array is 10 and the second largest element is 5
  
Input: arr[] = {10, 10, 10}
Output: The second largest does not exist.
Explanation: Largest element of the array is 10 there is no second largest element
**/


import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findSecondLargest(int n, int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if (arr[i] > secondMax && arr[i] < max) {
				secondMax = arr[i];
			}
		}
		return secondMax != Integer.MIN_VALUE?secondMax:-1;
	}
}

// Time - O(n)
// Space - O(1)
