class Solution {
    public int mySqrt(int x) {

        if( x < 2 ){
            return x;
        }

        return findSquareRoot(x, 1, x, -1);
    }

    int findSquareRoot(int x, int start, int end, int res){
        if(start > end){
            return res;
        }

        int mid = start + (end - start)/2;

        if(mid  <= x / mid){
            // potential candidate, move right
            return findSquareRoot(x, mid+1, end, mid);
        } else{
            // move left
            return findSquareRoot(x, start, mid-1, res);
        }

    }
}
