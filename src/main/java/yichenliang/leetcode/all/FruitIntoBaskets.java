package yichenliang.leetcode.all;

import java.util.HashSet;

public class FruitIntoBaskets {
	
public int totalFruit(int[] tree) {
        
        HashSet<Integer> set = new HashSet<>();
        
        if(tree == null || tree.length == 0){
            return 0;
        }
        
        int start = 0; 
        int end = 0;
        int len = tree.length;
        int res = Integer.MIN_VALUE;
        while(start < len){
            if(end == len){
                res = Math.max(res, end - start);
                break;
            }
            
            if(set.contains(tree[end])){
                
            }
            else{
                if(set.size() < 2){
                    set.add(tree[end]);
                }
                else if(set.size() == 2){
                    res = Math.max(res, end - start);
                    start++;
                    end = start;
                    set = new HashSet<Integer>();
                    end--;
                }
                
            }
            end++;
        }
        return res;
    }

}
