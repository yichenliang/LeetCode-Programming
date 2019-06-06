package yichenliang.leetcode.all;

import java.util.List;

/**
 *  364. Nested List Weight Sum II
 *  
 *  dfs : in this case, dfs do not need to write end/base case
 */

 interface NestedInteger {
     // Constructor initializes an empty nested list.
   

     // Constructor initializes a single integer.

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value);

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni);

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}


public class NestedListWeightSumII {
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
        
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        // find level
        int level = dfsLevel(nestedList);
        
        // calculate sum
        int sum = dfsSum(nestedList, level);
        
        return sum;
    }
    
    int dfsLevel(List<NestedInteger> nList){
        int maxLevel = 0;
        
        for(NestedInteger n : nList){
            if(n.isInteger()){
                maxLevel = Math.max(maxLevel, 1);
            }
            else{
                maxLevel = Math.max(maxLevel, dfsLevel(n.getList()) + 1);
            }
        }
        return maxLevel;
    }
    
    int dfsSum(List<NestedInteger> nList, int lv){
        
        int sum = 0;
        
        for(NestedInteger n : nList){
            if(n.isInteger()){
               sum += n.getInteger() * lv;
            }
            else{
               sum += dfsSum(n.getList(), lv - 1);
            }     
        }
        return sum;
    }

}
