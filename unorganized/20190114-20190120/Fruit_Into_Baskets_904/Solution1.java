
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
	
	 public int totalFruit(int[] tree) {
	        // We'll make a list of indexes for which a block starts.
	        List<Integer> blockLefts = new ArrayList();

	        // Add the left boundary of each block
	        for (int i = 0; i < tree.length; ++i)
	            if (i == 0 || tree[i-1] != tree[i])
	                blockLefts.add(i);

	        // Add tree.length as a sentinel for convenience
	        blockLefts.add(tree.length);

	        int ans = 0, i = 0;
	        search: while (true) {
	            // We'll start our scan at block[i].
	            // types : the different values of tree[i] seen
	            // weight : the total number of trees represented
	            //          by blocks under consideration
	            Set<Integer> types = new HashSet();
	            int weight = 0;

	            // For each block from the i-th and going forward,
	            for (int j = i; j < blockLefts.size() - 1; ++j) {
	                // Add each block to consideration
	                types.add(tree[blockLefts.get(j)]);
	                weight += blockLefts.get(j+1) - blockLefts.get(j);

	                // If we have 3+ types, this is an illegal subarray
	                if (types.size() >= 3) {
	                    i = j - 1;
	                    continue search;
	                }

	                // If it is a legal subarray, record the answer
	                ans = Math.max(ans, weight);
	            }

	            break;
	        }

	        return ans;
	    }
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int[] num1 = {3,3,3,1,2,1,1,2,3,3,4};
		
		
		int result = solution.totalFruit(num1);
		
		System.out.println(result);
     }
}


// time complexity: O(n)  where n is the length of tree.
// space complexity: O(n)


