class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList();
        
        // lets add at each digit in 1.. 9
        for(int i=1; i < 9; i++){
            // find all the sequential digits starting at 1
            int nextDigit = i+1;
            int num = i;

            while( num <= high && nextDigit <= 9){
                num = num * 10 + nextDigit;
                if(low <= num && num <= high){
                    res.add(num);
                }
                nextDigit++;
            }
        }

        Collections.sort(res);
        return res;
    }

    
}
