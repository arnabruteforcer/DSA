/** Problem Statement

You are given an array of numbers and a target 'S'. You need to find all pairs which sum up to
the target. The pairs should be sorted in non decreasing order. Also, the result should be 
in non decreasing order

**/

public class Solution {

    // Approach 1
    public static List<int[]> pairSum(int[] arr, int s) {
        ArrayList<int[]> pairs = new ArrayList<>();
        // a simple brute force approach comparing each pair and adding them to the result if the target meets    
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == s) {
                    int[] pair = new int[2];
                    if( arr[i]<arr[j] ) {
                        pair[0] = arr[i];
                        pair[1] = arr[j]; 
                    } else {
                        pair[0] = arr[j];
                        pair[1] = arr[i];
                    }
                    pairs.add(pair);
                }
           }
        }

      // sorting the pairs      
      Collections.sort(pairs, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                if(o1[1] > o2[1]) {
                    return 1;
                } else if(o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        }
        });
        return pairs;
    }
// Time complexity - O(n^2)
// Space complexity - O(1)        
        



// Approach 2 
public static List<int[]> pairSum(int[] arr, int s) {
        ArrayList<int[]> pairs = new ArrayList<>();
        
        // Space - O(n/2) = O(n)
        HashMap<Integer,Integer> numbers  = new HashMap<>();

        // Time - O(n)
        for(int i=0; i<arr.length; i++) {
            // check if the differnece from sum exits in map, that means we have a pair with sum equals target    
            if(numbers.containsKey(s-arr[i])) {
                int[] pair = new int[2];
                pair[0] = arr[i];
                pair[1] = s-arr[i];
                // swap the elements in ascending order
                if(pair[0] > pair[1]) {
                    int temp = pair[0];
                    pair[0] = pair[1];
                    pair[1] = temp;
                }
                // add the number can have multiple occurences, all such pairs needs to be added
                for(int j=1; j<=numbers.get(s-arr[i]); j++) {
                    pairs.add(pair);
                }
            }
            // add the number to the map, if it exists increase it occcurence count 
            numbers.put(arr[i], 
                numbers.getOrDefault(arr[i],0) + 1);
        }
        
        // sorting the result - O(n/2 * log(n/2)) = O(nlogn)
        Collections.sort(pairs, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                if(o1[1] > o2[1]) {
                    return 1;
                } else if(o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        }
        });
        return pairs;
    }
    // Time complexity = O(n) + O(nlogn)
    // Space complexity = O(pairs) = O(n)
}
