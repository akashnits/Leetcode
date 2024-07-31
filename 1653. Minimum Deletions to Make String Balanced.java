class Solution {
    public int minimumDeletions(String s) {
        return solve4(s);
    }

    // approach 1: 2 pass count
    // track count of 'a' to the right
    // track count of 'b' to the left
    int solve1(String s){
        int n = s.length();
        int[] aCount = new int[n];
        int[] bCount = new int[n];

        int countB = 0;
        int countA = 0;
        for(int i=0; i < n; i++){
            // b count excludes i, calculate left to right
            bCount[i] = countB; 
            if(s.charAt(i) == 'b'){
                countB++;
            }
            // a count excludes i, calculate right to left
            aCount[n-1-i] = countA;
            if(s.charAt(n-1-i) == 'a'){
                countA++;
            }
        }

        // second pass- at each i, number of chars out of place is aCount[i] + bCount[i]
        int minDel = Integer.MAX_VALUE;
        for(int i =0; i < n; i++){
            minDel = Math.min(aCount[i] + bCount[i], minDel);
        }
        return minDel;
    }

    // approach 2: Using stack - Greedy approach
    // pop 'b', whenever we see ba and calculate number of pops

    int solve2(String s){
        int n = s.length();
        Stack<Character> stack = new Stack();
        int minDel = 0;
        for(int i =0; i < n; i++){
            char c = s.charAt(i);

            if(c == 'a' && !stack.isEmpty() && stack.peek() == 'b'){
                // pop if stack top is 'b' when incoming char is 'a'
                stack.pop();
                minDel++;
            }else{
                // push the char now
                stack.push(c); // valid as either stack is empty ot stack top is 'a'
            }
        }
        return minDel;
    }

    // approach 3: two pass without extra memory
    int solve3(String s){
        int n = s.length();
        int minDel = n;

        int countB = 0;
        int countA = 0;

        for(int i=0; i < n; i++){
            // a count excludes i, calculate right to left
            if(s.charAt(n-1-i) == 'a'){
                countA++;
            }
        }

        for(int i=0; i < n; i++){
            // a count excludes i, calculate right to left
            if(s.charAt(i) == 'a'){
                countA--;
            }
            minDel = Math.min(minDel, countA + countB);
            // b count excludes i, calculate left to right
            if(s.charAt(i) == 'b'){
                countB++;
            }
        }

        return minDel;
    }

    // approach 4: Single pass
    int solve4(String s){
        int n = s.length();
        int minDeletions = 0;
        int bCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                // Two cases: remove 'a' or keep 'a'
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }

        return minDeletions;
    }

}
