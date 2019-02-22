class Solution {
    public String addBinary(String a, String b) {
        if(a == null || b == null) return "0";
        
        if(a == null) return b;
        if(b == null) return a;
        
        int lenA = a.length()-1;
        int lenB = b.length()-1;
        
        while(lenA - lenB != 0){
            if(lenA > lenB){
                b = "0" + b;
                lenB++;
            }
            else{
                a = "0" + a;
                lenA++;
            }
            
        }
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        while(lenA >= 0){
            int aa = a.charAt(lenA) - '0';
            int bb = b.charAt(lenB) - '0';
            int sum = aa + bb + carry;
            carry = sum/2;
            sum = sum % 2;
            sb.append(sum + "");
            lenA--;
            lenB--;
        }
        
        if(carry != 0){
            sb.append(carry + "");
        }
        
        return sb.reverse().toString();
       
    }
}

// time complexity: O(a + b)
// space complexity: O(N)