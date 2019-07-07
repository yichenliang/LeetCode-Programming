package yichenliang.leetcode.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 * 
 * HashMap + HashCode
 *
 * time complexity: O(1)
 * space complexity: O(1)
 */

public class EncodeAndDecodeTinyURL {
	
	Map<Integer, String> store = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        int key = longUrl.hashCode();
        store.put(key, longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
        int key = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        
        String url = store.get(key);
        
        return url;  
    }

}
