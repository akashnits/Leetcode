/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    int res = -1;
    public int firstBadVersion(int n) {
        solve(1, n);
        return res;
    }

    void solve(int start, int end ){
        if(start > end){
            return;
        }

        int mid = start + (end -start)/2;

        if(isBadVersion(mid)){
            // could be the first or later
            res = mid;
            // go left
            solve(start,  mid-1);
        } else{
            // go right
            solve(mid+1,  end);
        }
    }
}
