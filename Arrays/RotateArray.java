 /** Problem Statement 
 Given an array of integers arr[] of size N and an integer, the task is to rotate the array elements
 to the left by 'k' positions. where k is non -ve
Input: 
arr[] = {1, 2, 3, 4, 5, 6, 7}, k = 2
Output: 3 4 5 6 7 1 2

Input: arr[] = {3, 4, 5, 6, 7, 1, 2}, d=2
Output: 5 6 7 1 2 3 4   
**/


// Solution 1
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
