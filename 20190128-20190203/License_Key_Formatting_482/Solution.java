public class Solution {
	   
	public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    } 
	
		public static void main(String[] args) {
			Solution solution = new Solution();
			
			String S = "5F3Z-2e-9-w"; 
			int K = 3;
			String result = solution.licenseKeyFormatting(S, K);
	
			System.out.println(result);
     }
}


// time complexity: o(n)
// space complexity: o(n)
