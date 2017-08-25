package leetcode292;

/**
 * 
 *  You are playing the following Nim Game with your friend: There is a heap of 
 *  stones on the table, each time one of you take turns to remove 1 to 3 stones.
 *   The one who removes the last stone will be the winner. You will take the 
 *   first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a 
function to determine whether you can win the game given the number of stones 
in the heap.

For example, if there are 4 stones in the heap, then you will never win the 
game: no matter 1, 2, or 3 stones you remove, the last stone will always be 
removed by your friend. 
 * @author liyuncong
 *
 */
public class NimGame2 {
	/**
	 * 我每次可以选择remove 1 2 3个，对手也可以，只要我选择某一个时，无论对手选择什么，我都能赢，
	 * 就表示能赢
	 * Memory Limit Exceeded 
	 * @param n
	 * @return
	 */
    public boolean canWinNim(int n) {
       int arrayLen = Math.max(n, 6) + 1;
       boolean[] dp = new boolean[arrayLen];
       dp[0] = true;
       dp[1] = true;
       dp[2] = true;
       dp[3] = true;
       dp[4] = false;
       dp[5] = true;
       dp[6] = true;
       for(int i = 7; i < dp.length; i++) {
    	   dp[i] = (dp[i - 1 - 1] && dp[i - 1 - 2] && dp[i - 1 -3])
   		|| (dp[i - 2 - 1] && dp[i - 2 - 2] && dp[i - 2 -3])
   		||(dp[i - 3 - 1] && dp[i - 3 - 2] && dp[i - 3 -3]);
       }
       return dp[n];
    }
    
    public static void main(String[] args) {
		NimGame2 nimGame = new NimGame2();
		System.out.println(nimGame.canWinNim(1348820612));
	}
}
