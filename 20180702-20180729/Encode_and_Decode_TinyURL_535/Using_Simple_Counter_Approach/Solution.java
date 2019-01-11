//535. Encode and Decode TinyURL
//Approach #1 Using Simple Counter

import java.util.Map;
import java.util.HashMap;

 class Codec{
	
	int i = 0;
	Map<Integer, String> map = new HashMap<>();
	
	public String encode(String longUrl){
        map.put(i, longUrl);
		String shortUrl = "http://tinyurl.com/" + i;
		i++;
       	return shortUrl;	
	}
	
	public String decode(String shortUrl){
	  int key = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
	  String longUrl = map.get(key);
	  return longUrl;
	}
}

class Solution {
    
	    public static void main(String args[]) {
		
		Codec codec = new Codec();
		
		String longUrl_input1 = "https://leetcode.com/problems/design-tinyurl";
		String longUrl_input2 = "https://leetcode.com/problems/encode-and-decode-tinyurl/description/";
		String shortUrl_output1 = codec.encode(longUrl_input1);
		String shortUrl_output2 = codec.encode(longUrl_input2);
		System.out.println(shortUrl_output1);
		System.out.println(shortUrl_output2);
		
		String longUrl_output1 = codec.decode(shortUrl_output1);
		String longUrl_output2 = codec.decode(shortUrl_output2);
		System.out.println(longUrl_output1);
		System.out.println(longUrl_output2);
    }
}

