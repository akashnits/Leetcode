class Solution {
    public boolean confusingNumber(int n) {
        String str = String.valueOf(n);
        // reverse this string
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        char[] charArr = sb.toString().toCharArray();
        int size = charArr.length;

        Set<Character> validDigits = Set.of('0', '1', '6', '8', '9');
        for(int i=0; i < size; i++){
            // if encounter invalid char ?
            char c = charArr[i];
            if(!validDigits.contains(c)){
                // we have invalid number
                return false;
            }else{
                // we swap the digit with it's mirror image for 6 and 9
                if(c == '6'){
                    charArr[i] = '9';
                }else if(c == '9'){
                    charArr[i] = '6';
                }
            }
        }

        // build the number with charArr
        int num = 0;
        for(int i=0; i < size; i++){
            num = 10 * num + (charArr[i] - '0');
        }
        return num != n;
    }
}
