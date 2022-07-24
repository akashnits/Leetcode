//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> queue = new LinkedList<Long>();
        int i =0, j =0;
        int n = A.length;
        
        List<Long> result = new ArrayList<Long>();
        
        while( j < n){
            
            //do some calculation
            // if number is negative, add to queue
            if(A[j] < 0){
                queue.add(A[j]);
            }
            
            // check if we want to shrink
            int windowLength = j-i+1;
            if(windowLength == K){
                // we have to shrink now, before that record the result
                // of this window
                if(queue.size() == 0){
                    result.add(0L);
                }else{
                    // peek the value from list
                    long firstNegative = queue.peek();
                    result.add(firstNegative);
                    // check if A[i] equals firstNegative, if yes remove from queue
                    if(A[i] == firstNegative){
                        queue.poll();
                    }
                }
                // we shrink now
                    i++;
            }
            // expand
            j++;
        }
        
        long[] res = new long[result.size()];
        for(int m=0; m < result.size(); m++){
            res[m] = result.get(m);
        }
        return res;
    }
}
