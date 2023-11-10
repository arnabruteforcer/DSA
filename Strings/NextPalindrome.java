/** Problem Statement
Given a number , the goal is to find the next largest number which is a palindrome
**/

import java.util.* ;
import java.io.*; 

public class Solution {
  
	public static String nextLargestPalindrome(String number, 
	int length) {
		int[] arr = new int[length];
		for(int i=0; i<length; i++) {
			arr[i] = Integer.parseInt(String.
			valueOf(number.charAt(i)));
		}

		// converting the array to a palindrome by copying the left part to right part
		// copying the left part ensures the most significant digits are in place
		int mid = arr.length/2;
		mirrorleft(arr,mid);
		
		// if the copying results in a number > previous return the number
		
		String newStr = convertArrToString(arr);
		if(newStr.compareTo(number) > 0) {
			return newStr;
		} else {
			// if the new number is smaller or equal to previous
			// we increment the mid value making the increase the least
			if(arr[mid] == 9) {
				return formArrayIncrementingNine(arr);
			} else {
				if(length % 2 == 0) {
					arr[mid] += 1;
					arr[mid-1] += 1;
				} else {
					arr[mid] += 1;
				}
			}
			
		}
		return convertArrToString(arr);
	}



	private static String formArrayIncrementingNine(int[] arr) {
		int mid = arr.length / 2;
		int start = 0;
		if(arr.length % 2 == 0) {
			arr[mid-1] = 0;
			start = mid-1;  
		} else {
			arr[mid] = 0;
			start = mid;
		}

		boolean carry = true;
		// propagate towards left the carry of digit
		for(int i=start-1; i>=0; i--) {
			if( !carry ) {
				break;
			}
			if(arr[i] == 9) {
				arr[i] = 0;	
			} else {
				arr[i]+=1;
				carry = false;
			}
		}

		// copy the same to right
		mirrorleft(arr,mid);
		String result = convertArrToString(arr);
		if(carry) {
			arr[arr.length-1] += 1;
			result = "1" + convertArrToString(arr);
		}
		return result;
	}


	private static int[] mirrorleft(int[] arr, int end) {
		int length = arr.length;
		for(int i=0; i<end; i++) {
			arr[length-i-1] = arr[i];
		}
		return arr;
	}

        // helper method for converting array of numbers to string
	private static String convertArrToString(int[] arr) {
		StringBuilder result = new StringBuilder();
		for(int val : arr) {
			result.append(val);
		}
		return result.toString();
	}

}
  
