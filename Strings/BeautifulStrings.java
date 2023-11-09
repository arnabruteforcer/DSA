/** Problem Statement

Given a binary string consisting of only '0' and '1', it is considered beautiful 
if it contains an alternating sequence of 0s and 1s. Eg: 10101, 01010, 101, 0 etc
The aim to find the minimum number of operations to convert a binary string to a beautiful
one.  


 public class Solution {

    /** Optimal Approach
    Being a binary string there are only 2 combinations with the string staring with either 0 or 1
    making two combinations as 01010101... or 101010101010......

    1) We take each position in the array and transorm to both the first case and second case

    2) The result will be the minimum conversions required among the 2 cases
    **/ 
    public static int makeBeautiful(String str) {
          int zeroArrayStartChange = 0;
          int oneArrayStartChange = 0;

          // make the first character as 0
          for(int i=0; i<str.length(); i++) {
              if(i%2 == 0) {
                  // 0 based start in array
                  if(str.charAt(i)=='1') {
                      zeroArrayStartChange++;
                  } else {
                   oneArrayStartChange++; 
                  }
              } else { // if (i%2 ==1) 
                // 0 based start in array, odd indices should be 1
                 if(str.charAt(i) == '0') {
                  zeroArrayStartChange++;
              } else {
                  oneArrayStartChange++;
              }
            }
          }
          return Math.min(zeroArrayStartChange,
          oneArrayStartChange);
    }

   /* Time complexity - O(n)
      Space complexity - O(1) */ 

} 
  
