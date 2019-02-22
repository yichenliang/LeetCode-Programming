class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> array;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        array = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        int size = array.size();
        map.put(val, size);
        array.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        if(index < array.size() - 1){
            int lastElement = array.get(array.size() - 1);
            map.put(lastElement, index);
            array.set(index, lastElement);
        }
        map.remove(val);
        array.remove(array.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(rand.nextInt(array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */