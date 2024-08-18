class Solution {
    public boolean lemonadeChange(int[] bills) {
        // each lemonade costs $5
        // shopkeeper would always have amount in mutliple of 5
        // keep track of bills a shopkeeper has

        int[] billsFreq = new int[2]; // 0 -> $5, 1 -> $10, 2 -> $20

        for(int bill: bills){
            if(bill == 5){
                // case 1: buyer give $5
                billsFreq[0]++;
            }else if(bill == 10){
                // case 2: buyer give $10
                // transaction executed only if shopkeeper has $5 bill
                if(billsFreq[0] > 0){
                    // execute transaction
                    // take $10 and return $5
                    billsFreq[1]++;
                    billsFreq[0]--;
                }else{
                    return false;
                }
            }else{
                // case 3: buyer give $20
                // transaction executed only if shopkeeper has 3 -> $5 bills or 1 -> $10 and 1 -> $5
                if(billsFreq[1] > 0 && billsFreq[0] > 0){
                    // return $5 and $10, take $20
                    billsFreq[1]--;
                    billsFreq[0]--;
                }else if(billsFreq[0] > 2){
                    // return 3 bills of $5
                    billsFreq[0] -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
