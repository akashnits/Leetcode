class Solution {
    
    // special cases: 
    // I before V/X
    // X before L/C
    // C before D/M
    public int romanToInt(String s) {
        
        int sum =0;
        char[] romanChars = s.toCharArray();
        int n = romanChars.length;
        for(int i=0; i < n; i++){
            char c = romanChars[i];
            char nextChar= ' ';
            if(i < n-1){
                nextChar = romanChars[i+1];
            } 
            switch(c){
                case 'I':
                    //check if it's followed by V/X
                    if( nextChar == 'V'){
                        // we need to diff calc
                        i++;
                        sum  += 4;
                    }else if( nextChar == 'X') {
                        i++;
                        sum += 9;
                    }else{
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    //check if it's followed by L/C
                    if( nextChar == 'L'){
                        // we need to diff calc
                        i++;
                        sum  += 40;
                    }else if( nextChar == 'C') {
                        i++;
                        sum += 90;
                    }else{
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    //check if it's followed by D/M
                    if( nextChar == 'D'){
                        // we need to diff calc
                        i++;
                        sum  += 400;
                    }else if( nextChar == 'M') {
                        i++;
                        sum += 900;
                    }else{
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default: break;
            }
        }
        
        return sum;
    }
}
