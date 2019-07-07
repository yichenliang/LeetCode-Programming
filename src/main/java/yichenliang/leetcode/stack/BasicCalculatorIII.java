package yichenliang.leetcode.stack;

import java.util.LinkedList;

/**
 * 772. Basic Calculator III
 * 
 * stack
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 *
 */

public class BasicCalculatorIII {
	public int calculate(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        LinkedList<Integer> buff = new LinkedList<>();
        int num = 0;
        char sign = '+';
        
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char cur = s.charAt(i);
            
            if (cur >= '0' && cur <= '9') {
                num = 10 * num + (int)(cur - '0');
            } else if (cur == '(') {
                int j = i + 1; int cnt = 1;
                for (; j < n; ++j) {
                    if (s.charAt(j) == '(') ++cnt;
                    if (s.charAt(j) == ')') --cnt;
                    if (cnt == 0) break;
                }
                
                num = calculate(s.substring(i + 1, j));
                i = j;
            } 
            
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/' || i == n - 1) {
                switch (sign) {
                    case '+':
                        buff.addFirst(num);
                        break;
                    case '-':
                        buff.addFirst(-num);
                        break;
                    case '*':
                        int tmp = buff.removeFirst() * num;
                        buff.addFirst(tmp);
                        break;
                    case '/':
                        int tmp2 = buff.removeFirst() / num;
                        buff.addFirst(tmp2);
                        break;
                }
				num = 0;
                sign = cur;
            }
        }
        
        int res = 0;
        for (int i : buff) {
            res += i;
        }
        
        return res;
    }
}
