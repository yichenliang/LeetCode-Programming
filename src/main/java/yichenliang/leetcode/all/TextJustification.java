package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * 
 * time complexity: O(N)
 * space complexity:  O(maxWidth)
 */

public class TextJustification {
	 public List<String> fullJustify(String[] words, int maxWidth) {
	        List<String> res = new ArrayList<>();
	        int index = 0;
	        while(index < words.length){
	            int count = words[index].length();
	            int last = index + 1; // the next word 
	            while(last < words.length){
	                if(words[last].length() + 1 + count > maxWidth){
	                    break;
	                }
	                count = count + 1 + words[last].length();
	                last++;
	            }
	            
	            StringBuilder sb = new StringBuilder();
	            sb.append(words[index]);
	            
	            if(last == words.length){
	                int position = last - 1 - index;
	                for(int i = 0; i < position; i++){
	                   sb.append(" ");
	                   sb.append(words[index + i + 1]);
	                }
	                
	                // add space util reaching the maxWidth
	                for(int j = 0; j < maxWidth - count; j++){
	                    sb.append(" ");
	                }    
	            }
	            else{
	                int position = last - 1 - index;
	                if(position != 0){
	                    int numOfExtraSpace = maxWidth - count;
	                    int normalExtra = numOfExtraSpace / position;
	                    int specialExtra = numOfExtraSpace % position;
	                    for(int i = 1; i <= position; i++){
	                        sb.append(" ");
	                        if(specialExtra != 0){
	                            sb.append(" ");
	                            specialExtra--;
	                        }
	                        for(int j = normalExtra; j > 0; j--){
	                            sb.append(" ");
	                        }
	                        sb.append(words[index + i]);
	                    }
	                }
	                else{
	                    int extraSpace = maxWidth - count;
	                    for(int j = 0; j < extraSpace; j++){
	                        sb.append(" ");
	                    }
	                }
	                
	            }
	            
	            res.add(sb.toString());
	            index = last;         
	        }
	        return res;
	    }
}
