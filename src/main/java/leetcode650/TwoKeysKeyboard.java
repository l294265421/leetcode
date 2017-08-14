package leetcode650;

/**
 * 
Initially on a notepad only one character 'A' is present. You can perform two 
operations on this notepad for each step:

    Copy All: You can copy all the characters present on the notepad 
    (partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.

Given a number n. You have to get exactly n 'A' on the notepad by performing the 
minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.

Note:

    The n will be in the range [1, 1000].

 * @author liyuncong
 *
 */
public class TwoKeysKeyboard {
	/**
	 * 
	 * 正确性不能理解
	 * @param n
	 * @return
	 */
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
        	// 最多需要i步：1copy i-1paste
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                	// 在有dp[j]个A时，一次copy和（i/j）- 1次paste，就有dp[i]个A了
                    dp[i] = dp[j] + (i/j);
                    break;
                }
                
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
    	TwoKeysKeyboard twoKeysKeyboard = new TwoKeysKeyboard();
		System.out.println(twoKeysKeyboard.minSteps(9));
	}
}
