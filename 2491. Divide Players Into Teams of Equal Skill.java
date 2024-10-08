class Solution {
    // subset ( size == 2 ) sum equals k
    public long dividePlayers(int[] skill) {
        

        return solve2(skill);
    }

    // two pointer approach
    long solve1(int[] skill){
        int n = skill.length;
        // sort the array
        Arrays.sort(skill);
        int totalTeamSkill = skill[0] + skill[n-1];

        long res = 0;
        int i =0;
        int j = n-1;

        while(i < j){
            if(skill[i] + skill[j] != totalTeamSkill){
                return -1;
            }
            res += skill[i] * skill[j];
            i++;
            j--;
        }
        return res;
    }

    // use a map
    long solve2(int[] skill){
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> freqMap = new HashMap();
        for (int s : skill) {
            totalSkill += s;
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        int targetTeamSkill = totalSkill / (n / 2);

        // make a pair (skill1, skill2)
        long res = 0;

        for(int player1Skill: skill){
            int player2Skill = targetTeamSkill - player1Skill;

            if(!freqMap.containsKey(player2Skill)){
                return -1;
            }

            if(freqMap.get(player2Skill) > 0){
                // we can make a pair
                res += player1Skill * player2Skill;
                freqMap.put(player2Skill, freqMap.get(player2Skill)-1);
            }else{
                // couldn't make pair
                return -1;
            }
        }
        return res/2;
    }
}
