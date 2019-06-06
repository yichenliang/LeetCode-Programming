package yichenliang.leetcode.all;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  767. Reorganize String
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class ReorganizeString {
	
	public String reorganizeString(String S) {
        
        int len = S.length();
        int[] count = new int[26];
        for(int i = 0; i < len; i++){
            char ch = S.charAt(i);
            count[ch - 'a']++;
        }
        
        Comparator<CharPair> cmp = new Comparator<CharPair>(){
           
            public int compare(CharPair a, CharPair b){
                return a.count == b.count ? a.letter - b.letter : b.count - a.count;
            }
        };
        
        PriorityQueue<CharPair> pq = new PriorityQueue<>(2, cmp);
        
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                if(count[i] > (len + 1) / 2){
                    return "";
                }
                pq.add(new CharPair(count[i], (char)('a' + i)));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2){
            CharPair cp1 = pq.poll();
            CharPair cp2 = pq.poll();
            
            sb.append(cp1.letter);
            sb.append(cp2.letter);
            if(cp1.count - 1 > 0){
                cp1.count--;
                pq.add(cp1);
            }
            
            if(cp2.count - 1 > 0){
                cp2.count--;
                pq.add(cp2);
            }
        }
        if(pq.size() > 0){
            sb.append(pq.poll().letter);
        }
        return sb.toString();
    }

}

class CharPair{
    int count;
    char letter;
    CharPair(int c, char l){
        count = c;
        letter = l;
    }
}
