class Solution {
    public boolean backspaceCompare(String S, String T) {
	        String s = builderString(S);
	        String t = builderString(T);
	        return s.equals(t);
	    }
	    
	    private String builderString(String S){
	        if(S == null || S.length() == 0) return "";
	        Stack<Character> store = new Stack<>();
	        
	        for(int i = 0; i < S.length(); i++){
	            if(S.charAt(i) == '#'){
	                if(!store.isEmpty()){
	                    store.pop();
	                }
	            }
	            else{
	                store.push(S.charAt(i));
	            }
	        }
	        String result = "";
	        while(!store.isEmpty()){
	            result = store.pop() + result;
	        }
	        return result;
	    }
}

// time complexity: O(S+T)
// space complexity: O(S+T)