//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // need to search pat in txt
        int n = txt.length();
        int m = pat.length();
        
        // invalid case - if pattern length is greater than text
        if(m > n){
            return 0;
        }
        
        int count =0;
        
        // loop over pattern and record frequency 
        Map<Character, Integer> freqMap = new HashMap();
        for(char c: pat.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        int uniqueCharCount = freqMap.size();
        
        int i =0, j=0;
        int windowLength =0;
        while( j < n){
            
            // do something here 
            // check if freqMap contains this char
            char ch = txt.charAt(j);
            if(freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.get(ch) - 1);
                if(freqMap.get(ch) == 0){
                    uniqueCharCount--;
                }
            }
            
            // check if uniqueCharCount == 0, make it undesirable
            while(uniqueCharCount == 0){
                windowLength = j-i+1;
                // check windowLength if equals to pattern
                if(windowLength == m){
                    count++;
                }
                // we have to shrink now
                char startCh = txt.charAt(i);
                if(freqMap.containsKey(startCh)){
                    freqMap.put(startCh, freqMap.getOrDefault(startCh, 0) + 1);
                    // check if startCh wasn't already present in freqMap
                    if(freqMap.get(startCh) == 1){
                        uniqueCharCount++;
                    }
                }
                
                
                i++;
            }
            
            // expand here
            j++;
        }
        return count;
    }
}
