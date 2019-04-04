package yichenliang.leetcode.withoutTopic;

/**
 *  923. 3Sum With Multiplicity
 *  
 *  Math, Combination
 *  
 */

public class _3SumWithMultiplicity {
	
	public int threeSumMulti(int[] A, int target) {
        
        // calculate the frequency of the element in A
        long[] store = new long[101];
        
        for(int a : A){
            store[a]++;
        }
        
        long ans = 0;
        
        // i + j + k == target, i <= j <= k 
        for(int i = 0; i <= target; i++){
            for(int j = i; j <= target; j++){
                int k = target - i - j;
                if(k < 0 || k < j || k < i || k > 100){
                    continue;
                }
                
                if(store[k] == 0 || store[i] == 0 || store[j] == 0){
                    continue;
                }
                
                if(i == j && j == k){ // i = j = k
                    long n = store[i];
                    ans += n*(n-1)*(n-2)/6;  // 6 = 3!
                }
                else if(i == j && j != k){
                    long n = store[i];
                    ans += n*(n-1)/2*store[k];  // 2 = 2!
                }
                else if(i != j && j == k){
                    long n = store[k];
                    ans += n*(n-1)/2*store[i];  // 2 = 2!
                }
                else if(i != j && j != k){
                    ans += store[i] * store[j] * store[k];
                }
            }
            
        }
    
        return (int) (ans % (1e9 + 7));
    }

}
