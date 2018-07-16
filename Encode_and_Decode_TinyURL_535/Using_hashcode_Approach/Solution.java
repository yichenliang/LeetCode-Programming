//535. Encode and Decode TinyURL
//Approach #3 Using hashcode

import java.util.Map;
import java.util.HashMap;


class Codec {
    
	Map<Integer, String> map = new HashMap<>();
    

    public String encode(String longUrl) {
    	int hashKey = longUrl.hashCode();  //Returns a hash code value for the object.
        map.put(hashKey, longUrl);
        return "http://tinyurl.com/" + hashKey;
    }

    public String decode(String shortUrl) {
    	String keyS = shortUrl.replace("http://tinyurl.com/", "");
    	return map.get(Integer.parseInt(keyS));
    }
}


public class Solution {
    
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
