package yichenliang.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  811. Subdomain Visit Count
 *  
 *  String
 *  
 *  time complexity: O()
 *  space complexity: O()
 */

public class SubdomainVisitCount {
	
	public List<String> subdomainVisits(String[] cpdomains) {
        
        List<String> res = new ArrayList<>();
        
        if(cpdomains ==null || cpdomains.length == 0){
            return res;
        }
        
        int len = cpdomains.length;
        Map<String, Integer> store = new HashMap<>();
        
        String[] curElement = new String[2];
        for(int i = 0; i < len; i++){
            curElement = cpdomains[i].split(" ");
            String curDomain = curElement[1];
            int curNumber = Integer.parseInt(curElement[0]);
            
            String[] curName = curDomain.split("\\.");
            for(int j = 0; j < curName.length; j++){
                String key = "";
                int temp = j;
                while(temp < curName.length){
                    key += curName[temp] + ".";
                    temp++;
                }
                key = key.substring(0, key.length() -1);
                
                if(store.containsKey(key)){
                    store.put(key, store.get(key) + curNumber);
                }
                else{
                    store.put(key, curNumber);
                }   
            }    
        }
        
        // build res from store
        for(String k : store.keySet()){
            String result = store.get(k) + " " + k;
            res.add(result);
        }
        return res;
    }
}
