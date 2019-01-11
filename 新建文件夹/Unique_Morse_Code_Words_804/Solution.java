import java.util.HashSet;


//804. Unique Morse Code Words
//Approach #1: HashSet

class Solution {
    
	public int uniqueMorseRepresentations(String[] words) {
        
        String[] morseCode = {".-","-...","-.-.","-..",".",
                              "..-.","--.","....","..",".---",
                              "-.-",".-..","--","-.","---",".--.",
                              "--.-",".-.","...","-","..-","...-",
                              ".--","-..-","-.--","--.."};
        
        HashSet<String> morseWord = new HashSet<>();
        
        for(String word: words){
            StringBuilder mWord = new StringBuilder();
             
            for (char c : word.toCharArray()){
                 mWord.append(morseCode[c - 'a']);   //c-'a': characters are ascii values,
             }
            
             morseWord.add(mWord.toString());
        }
        
        return morseWord.size();
        
    }



	  public static void main(String args[])
    {
		Solution solution = new Solution();
		String[] words = {"gin", "zen", "gig", "msg"};
		
    	int res = solution.uniqueMorseRepresentations(words);
    	System.out.println(res);
    }
}


// https://www.geeksforgeeks.org/hashset-in-java/