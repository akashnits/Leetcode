class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // 2D array 
        // 1. containing distinct elements in each row
        // 2. rows can contain different number of elements

        // we need to minimize row's count

        // create freqency map
        Map<Integer, Integer> freqMap = new HashMap();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // iterate over freqMap and create rows
        List<Set<Integer>> resList = new ArrayList();

        while(freqMap.size() != 0){
            // create a new row
            resList.add(new HashSet());
            Set<Integer> set;
            List<Integer> toErase= new ArrayList();
            for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
                int ele = entry.getKey();
                int count = entry.getValue();

                set = resList.get(resList.size()-1);
                // put it in the last row if it doesn't contain the ele
                if(!set.contains(ele)){
                    set.add(ele);
                    // decrement freq count
                    freqMap.put(ele, freqMap.get(ele) - 1);
                    if(freqMap.get(ele) == 0){
                        // remove from map
                        toErase.add(ele);
                    }
                }
            }

            // erase from map
            for(int eraseEle: toErase){
                freqMap.remove(eraseEle);
            }
        }

        // convert from List<Set<Integer>> to List<List<Integer>>
        return convertSetListToListList(resList);

    }

     public List<List<Integer>> convertSetListToListList(List<Set<Integer>> setList) {
        List<List<Integer>> listList = new ArrayList<>();

        for (Set<Integer> set : setList) {
            List<Integer> list = new ArrayList<>(set);
            listList.add(list);
        }

        return listList;
    }
}
