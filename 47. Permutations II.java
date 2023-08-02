class Solution {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap(); // ele -> freq

        // create a map containing ele with freq
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        solve(nums.length, map, new ArrayList());
        return result;
    }


    void solve(int n, Map<Integer, Integer> map, List<Integer> op){
        if(op.size() > n){
            return;
        }

        if(op.size() == n){
            // candidate
            result.add(new ArrayList(op));
        }


        // loop over choices
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(freq == 0) continue;

            // do something
            op.add(num);
            map.put(num, --freq);

            // recurse
            solve(n, map, op);

            // undo
            op.remove(op.size()-1);
            map.put(num, ++freq);

        }
    }
}
