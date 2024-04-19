class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb= new StringBuilder();

        int m = a.length();
        int n = b.length();
        int carry =0, i=m-1, j=n-1;
        int digitSum = 0;
        while(i >= 0 || j >= 0){
            
            int c1 = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int c2 = (j >= 0) ? b.charAt(j--) - '0': 0;

            int xorDigits = (c1 ^ c2);
            digitSum = xorDigits ^ carry;
            carry = (xorDigits & carry) | (c1 & c2);

            sb.insert(0, digitSum);
        }

        if(carry == 1){
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
