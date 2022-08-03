//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    static int segTree[];
    
    public static int[] constructST(int arr[], int n)
    {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        segTree = new int[max_size];
        buildSegTree(arr, 0, n-1, 0);
        return segTree;
    }
    
    static int buildSegTree(int[] arr, int start, int end, int i){
        // base condition
        if( start == end ){
            segTree[i] = arr[start];
            return segTree[i];
        }
        
        int mid = start + (end - start)/2;
        segTree[i] = Math.min(buildSegTree(arr, start, mid, 2*i+1), buildSegTree(arr, mid+1, end, 2*i+2));
        return segTree[i];
    }
    
    
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int segTree[], int n, int l, int r)
    {
       return minInRange(segTree, segTree.length, 0, segTree.length-1, l, r, 0);
    }
    
    static int minInRange(int[] segTree, int n, int start, int end, int l, int r, int i){
        // base condition
        // invalid case
        if(start > r || end < l){
            return Integer.MAX_VALUE;
        }
        
        if( start >= l && end <= r ){
            return segTree[i];
        }
        
        int mid = start + (end-start)/2 ;
        return Math.min(minInRange(segTree, n, start, mid, l, r, 2*i+1), 
                        minInRange(segTree, n, mid+1, end, l, r, 2*i+2));
        
    }
    
    
}
