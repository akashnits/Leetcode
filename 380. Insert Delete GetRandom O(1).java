class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        // Move last element into val's position
        list.set(index, last);
        map.put(last, index);

        // Remove last position
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
