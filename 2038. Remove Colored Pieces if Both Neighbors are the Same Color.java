class Solution {
    public boolean winnerOfGame(String colors) {
        char[] colorsArray = colors.toCharArray();

        int aliceChanceCount = 0;
        int bobChanceCount = 0;

        int currACount =0;
        int currBCount =0;
        for(int i=0; i < colorsArray.length; i++){
            char c = colorsArray[i];
            if(c == 'A'){
                // B sequence broken - check is B sequence was >= 3
                if(currBCount >= 3){
                    bobChanceCount += currBCount-2;
                }
                // B sequence is broken, so make it 0
                currBCount =0;

                // A sequence forming
                currACount++;
            } else if(c == 'B'){
                // A sequence broken - check is A sequence was >= 3
                if(currACount >= 3){
                    aliceChanceCount += currACount-2;
                }
                // A sequence is broken, so make it 0
                currACount =0;

                // B sequence forming
                currBCount++;
            }
        }

        // check of A / B count
        if(currACount >= 3){
            aliceChanceCount += currACount-2;
        }

        if(currBCount >= 3){
            bobChanceCount += currBCount-2;
        }

        return aliceChanceCount > bobChanceCount;
    }
}
