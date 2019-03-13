package yichenliang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  332. Reconstruct Itinerary
 * 
 */

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0) return res;
        
        Map<String, LinkedList<String>> store = new HashMap<>();
        int resLen = tickets.length + 1;
        int size = 0;
        
        for(int i = 0; i < tickets.length; i++){
            String key = tickets[i][0];
            if(store.containsKey(key)){
                insertNew(store.get(key), tickets[i][1]);
            }
            else{
                LinkedList<String> temp = new LinkedList<>();
                temp.add(tickets[i][1]);
                store.put(key, temp);
            }
        }
        
        res.add("JFK");
        size++;
        String start = "JFK";
        //String end = "";
        while(size < resLen){
            LinkedList<String> cur = store.get(start);
            if(cur.size() == 1){
                res.add(cur.get(0));
                size++;
                start = cur.get(0);
            }
            else{
                start = cur.remove(0);
                res.add(start);
                size++;    
            }           
        }
        return res;
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
