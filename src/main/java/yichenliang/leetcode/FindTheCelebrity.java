package yichenliang.leetcode;

/**
 *  277. Find the Celebrity
 *  
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class FindTheCelebrity{
	
	public int findCelebrity(int n) {
        
        int candidate = 0;
        
        // find candidate 
        for(int i = 0; i < n; i++){
            if(!knows(i, candidate)){
                candidate = i;
            }
        }
        
        // check candidate, is celebrity? 
        for(int j = 0; j < n; j++){
            if(candidate != j){
               if(!(!knows(candidate, j) && knows(j, candidate))){
                    return -1;
                } 
            }
            
        }
        return candidate;
    }
	
	boolean knows(int i, int j) {
		
		// The knows API is defined in the parent class Relation
		
		return true;
	}

}
