import java.util.* ;
import java.io.*; 
public class Solution {

	// Approach 1
	public static int firstMissingOne(int[] arr, int n) {
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

	

 	/** Approach 2
  
	1) Store all the occurences of +ve elements in an array/map in sequence

 	2) Check in linear order, the occurence of elements and if the count=0, we return the element

  	**/
	public static int firstMissingTwo(int[] arr, int n) {

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




	
	/** Approach 3
	1) Call a function that will segregate the positive integer to the negative integers i.e move all non-positive elements to the right side, 
	and return the index at which non-positive integers START.
	
	2) Now we can ignore non-positive elements and consider only the part of the array which contains all positive elements. 
	   We traverse the array containing all positive numbers. To mark the presence of an element ARR[i], 
	   we change the sign of value at index ARR[i] to negative i.e mark the presence of element 1 by making the element of array 
	   at index 1 to negative, given that the index lies in that segment of positive elements. 

	3) To find the smallest positive missing element, we traverse the positive elements array again and print the first index which has
	   positive value. In case all elements are negative, our index is SIZE - 1. We subtract 1 from the index and that would be the answer.
	**/
	public static int firstMissingThree(int[] arr, int n) {
		// swap elements keeping the -ve integers at end and +ve at start
		int posIndex = 0;
		int negIndex = n-1;
		while(posIndex < negIndex) {
			// if positive index is pointing to a +ve integer 1,2,3 ..., ignore
			if(arr[posIndex]>0) {
				posIndex++;
			}
			// if negative index is pointing to a non+ve integer 0,-1,-2,3 ..., ignore
            else if(arr[negIndex]<=0) {
				negIndex--;
			}
			// else swap the elements
			else {
				// swap the elements
				int temp = arr[posIndex];
				arr[posIndex] = arr[negIndex];
				arr[negIndex] = temp;
			}
		}


		// counting all positive number
		if(arr[posIndex] > 0) {
			posIndex++;
		}

		for(int i=0; i<posIndex; i++) {
			if(arr[i]<=n) {
				// There can be duplicate elements where an element is already marked -ve
				// In that case we need to take the absolute ensureing we are always under the 
				// bound index range
				if(arr[Math.abs(arr[i])-1] > 0) {
					arr[Math.abs(arr[i])-1]*=-1;
				}
			}
		}

		int i = 0;
		// check if any index within the +ve range is not -ve ,
		// we return that missing number
		for(i=0; i<posIndex; i++) {
			if( arr[i]>0 ) {
				break;
			}
		}

		return i+1;
		}
	// Time complexity - O(n)
	// Space complexity - O(1)
	
}
