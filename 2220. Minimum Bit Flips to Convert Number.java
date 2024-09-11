class Solution {
    public int minBitFlips(int start, int goal) {
        return method4(start, goal);
    }


    // use division
    int method1(int start, int goal){
        int count = 0;
        while(start > 0 || goal > 0){
            if(start == 0 && goal % 2 != 0){
                count++;
            }else if(goal == 0 && start % 2 != 0){
                count++;
            }else{
                // both are non-zero
                int startRemainder = start % 2;
                int goalRemainder = goal % 2;

                count += startRemainder == goalRemainder ? 0 : 1;
            }
            start = start/2;
            goal = goal/2;
        }
        return count;
    }

    // use right shift approach 
    int method2(int start, int goal){
        int count = 0;
        while(start > 0 || goal > 0){
            if((start & 1) != (goal & 1)){
                count++;
            }

            start >>= 1;
            goal >>= 1;
        }
        return count;
    }

    // xor and count number of set bits
    int method3(int start, int goal){
        int count = 0;
        int xorResult = start ^ goal;

        while(xorResult != 0){
            count += xorResult & 1;
            xorResult >>= 1;
        }

        return count;
    }

    // Brian Kernighan's algo
    int method4(int start, int goal){
        // count set bits using n & n-1
        int count = 0;
        int xorResult = start ^ goal;

        while(xorResult != 0){
            xorResult &= (xorResult -1);
            count++;
        }
        return count;
    }
}
