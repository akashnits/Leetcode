class RandomizedSet {
    Map<Integer, Integer> map; // maps item to indices
    List<Integer> list; // contains list of items
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        
        // put the value in list
        list.add(val);
        //put it in the map
        map.put(val, list.size()-1);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(map.size() == 0 || !map.containsKey(val)){
            return false;
        }
        
        
        
        // get index from map
        int removeIdx = map.get(val);
        int lastIdx = list.size()-1;
        // swap this index with last element index
        int lastElement = list.get(lastIdx);
        list.set(lastIdx, list.get(removeIdx));
        list.set(removeIdx, lastElement);
        
        // update map with correct idx
        map.put(lastElement, removeIdx);
        
        // remove the element at last element
        list.remove(lastIdx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randomIdx = rand.nextInt(list.size());
        
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
