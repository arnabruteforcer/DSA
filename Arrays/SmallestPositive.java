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

	

 	// Approach 2
	public static int firstMissing(int[] arr, int n) {

		// space for storing the n +ve numbers
		int[] numCount = new int[n];

		// we traverse through the array
		for(int i=0; i<arr.length; i++) {
			// store the count of each +ve number in array
			if(arr[i] > 0 && arr[i]<=n ) {
				numCount[arr[i]-1]++;
			}
		}


		// traverse the array among n numbers
		for(int i=0; i<numCount.length; i++) {
			if(numCount[i] == 0) {
				return i+1;
			}
		}

		return n+1;
	}
	// Time complexity - O(n)
	// Space complexity - O(n)  
}
