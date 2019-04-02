package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  332. Reconstruct Itinerary
 *  
 *  DFS
 * 
 */

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0) return res;
        
        Map<String, List<String>> store = new HashMap<>();
        int resLen = tickets.length + 1;
        //int[] size = {0};
        
        for(int i = 0; i < tickets.length; i++){
            String key = tickets[i][0];
            if(store.containsKey(key)){
                insertNew(store.get(key), tickets[i][1]);
            }
            else{
                List<String> temp = new LinkedList<>();
                temp.add(tickets[i][1]);
                store.put(key, temp);
            }
        }
        
        res.add("JFK");
        //size[0]++;
        String start = "JFK";
        
        dfsHelper(res, start, store, 1, resLen);
        
        return res;
       
    }
    
    boolean dfsHelper(List<String> res, String start,  Map<String, List<String>> store, int size, int resLen){
        
        // end case
        if(size == resLen){
            return true;
        }
        if(!store.containsKey(start)){
            //res.remove(res.size() - 1);
            return false;
        }
        
        // normal case
        int i = 0;
        List<String> ends = store.get(start);
        while(i < ends.size()){
            String end = ends.remove(i);
            res.add(end);
            //size[0]++;
            if(dfsHelper(res, end, store, size + 1, resLen)){
                return true;
            }
            res.remove(res.size() - 1);
            //size[0]--;
            //ends.addLast(end);
            insertNew(ends, end);
            i++;
        }
        return false;
        
    }
    
    void insertNew(List<String> positions, String p){
        int i = 0;
        for(i = 0; i < positions.size(); i++){
            String front = positions.get(i);
            if(front.compareTo(p) > 0){
                break;
            }
        }
        
        // insert
        positions.add(i, p);     
    }
}
