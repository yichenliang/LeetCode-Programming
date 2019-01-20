import java.util.HashSet;

public class Solution {
	
	public int numUniqueEmails(String[] emails) {
	        HashSet<String> record = new HashSet<>();
	        for(String email : emails) {
	        	int i = email.indexOf('@');
	        	String local = email.substring(0, i);
	        	String rest = email.substring(i);
	        	if(local.contains("+")) {
	        		local = local.substring(0, local.indexOf('+'));
	        	}
	        	local = local.replaceAll(".", "");
	        	record.add(local + rest);
	        }
	        return record.size();
	}

	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		String[] input = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		
		int result = solution.numUniqueEmails(input);
		
		System.out.println(result);
     }
}


// time complexity: O(n)
// space complexity: O(n)


