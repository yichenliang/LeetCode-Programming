class Solution {
    public void reverseString(char[] s) {
        if(s==null || s.length <= 1){
            return;
        }
        
        int ptr1 = 0;
        int ptr2 = s.length - 1;
        
        while(ptr1 <= ptr2){
            char temp = s[ptr1];
            s[ptr1] = s[ptr2];
            s[ptr2] = temp;
            ptr1++;
            ptr2--;  
        }
    }
}