import java.util.* ;
import java.io.*; 
public class Solution {

	// Approach 1
	public static int firstMissing(int[] arr, int n) {
		// The array is sorted initially
		Arrays.sort(arr);

		// the smallest positive number is set to 1
		int smallestPositive = 1;

		// we traverse through the array
		for(int i=0; i<arr.length; i++) {
			// if the number is present we increment the counter to the next +ve 
			if(arr[i] == smallestPositive) {
				smallestPositive++;
			// if the next +ve number is not present in array and we exceed it,
			// we return the number 	
			} else if (arr[i] > smallestPositive) {
				break;
			}
		}
		return smallestPositive;
	}
	// Time complexity - O(nlogn)
	// Space complexity - O(1)











  
}
