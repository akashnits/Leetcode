class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start =1;
        int len = quantities.length;

        int max = Integer.MIN_VALUE;
        for(int quantity: quantities){
            max = Math.max(max, quantity);
        }
        int end = max; // max quantity give to any store
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(canDistribute(quantities, n, mid)){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }

    boolean canDistribute(int[] quantities, int n, int maxQuantity){
         for(int i=0; i< quantities.length; i++){
            int products = quantities[i];
            n -= (products/maxQuantity);
            if(products % maxQuantity != 0){
                n--;
            }
        }
        return n >= 0;
    }
}
