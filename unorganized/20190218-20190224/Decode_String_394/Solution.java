class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String result = "";
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == '['){
                stringStack.push(result);
                result = "";
                index++;
            }
            else if(s.charAt(index) == ']'){
                String temp = stringStack.pop();
                Integer number = numStack.pop();
                for(int i = 0; i < number; i++){
                    temp += result;
                }
                result = temp;
                index++;
            }
            else if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + s.charAt(index) - '0';
                    index++;
                }
                numStack.push(count);
            }
            else{
                result += s.charAt(index);
                index++;
            }
        }
        return result;
    }
}

// time complexity: O(N)
// space complexity: O(N)