package yichenliang.leetcode.dp;

/**
 * 983. Minimum Cost For Tickets
 * 
 *  dynamic programming
 * 
 * time complexity: O(366)
 * space complexity: O(366)
 * 
 * 2019/8/15
 * 
 */

public class MinimumCostForTickets {
	
	public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int lastDay = days[len - 1];
        int[] travelDays = new int[lastDay + 1];
        int[] money = new int[lastDay + 1];
        for(int day : days) travelDays[day] = 1;
        money[0] = 0;
        for(int i = 1; i < money.length; i++){
            if(travelDays[i] != 1){ // do not travel in this day
                money[i] = money[i - 1];
                continue;
            }
            money[i] = money[i - 1] + costs[0];
            int _7daysAgo = Math.max(0, i - 7);
            money[i] = Math.min(money[i], costs[1] + money[_7daysAgo]);
            int _30daysAgo = Math.max(0, i - 30);
            money[i] = Math.min(money[i], costs[2] + money[_30daysAgo]);    
        }
        return money[lastDay];
    }

}
