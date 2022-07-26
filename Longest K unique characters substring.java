//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int i=0, j=0;
        int maxLengthWindow = -1;
        
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        int windowLength =0;
        
        int distinctCharCount = 0;
        while( j < n){
            
            // add char to freqMap
            char c = s.charAt(j);
            freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
            distinctCharCount= freqMap.size();

            windowLength = j-i+1;
            
            // check for possible candidate
            if(distinctCharCount == k){
                maxLengthWindow = Math.max(maxLengthWindow, windowLength);
            }
            
            // check if we need to shrink - we do this if distinct char in window > k
            while(distinctCharCount > k){
                // drop ith char from map
                char ch = s.charAt(i);
                freqMap.put(ch, freqMap.get(ch)-1);
                if(freqMap.get(ch) == 0){
                    // remove char from frequency map
                    freqMap.remove(ch);
                }
                distinctCharCount= freqMap.size();
                i++;
            }
            
            // expand
            j++;
        }
        
        return maxLengthWindow;
    }
}
