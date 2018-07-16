//535. Encode and Decode TinyURL
//Approach#5 Random fixed-length encoding


import java.util.Random;
import java.util.HashMap;


 class Codec {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
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
