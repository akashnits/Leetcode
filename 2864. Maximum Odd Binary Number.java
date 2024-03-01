class Solution {
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0;

        char[] charArray = s.toCharArray();

        for(char c: charArray){
            countOnes += c == '1' ? 1: 0;
        }

        char[] arr = new char[s.length()];
        Arrays.fill(arr, '0');

        
        arr[s.length()-1] = '1';
        countOnes--;

        int i=0;
        while(countOnes-- > 0){
            arr[i++] = '1';
        }

        return new String(arr);
    }
}
