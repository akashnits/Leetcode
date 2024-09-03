class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        int sum =0;
        int idx = 0;
        for(char c: s.toCharArray()){
            int num = (int) (c -'a') +1;
            sum += getSum(num);
        }
        k--;
        
        while(k-- > 0){
            sum = getSum(sum);
        }
        return sum;
    }


    int getSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
