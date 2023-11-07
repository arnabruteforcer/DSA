/** Problem Statement

You are given an array of numbers and a target 'S'. You need to find all pairs which sum up to
the target. The pairs should be sorted in non decreasing order. Also, the result should be 
in non decreasing order

**/

// Approach 2 
public static List<int[]> pairSum(int[] arr, int s) {
        ArrayList<int[]> pairs = new ArrayList<>();
        
        // Space - O(n/2) = O(n)
        HashMap<Integer,Integer> numbers  = new HashMap<>();

        // Time - O(n)
        for(int i=0; i<arr.length; i++) {
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
                // add the numbers x number of times
                for(int j=1; j<=numbers.get(s-arr[i]); j++) {
                    pairs.add(pair);
                }
            }
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
    // Space complexity = O(pairs)
}
