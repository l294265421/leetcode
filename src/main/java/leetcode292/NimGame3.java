package leetcode292;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
public class NimGame3 {
	/**
	 * 我每次可以选择remove 1 2 3个，对手也可以，只要我选择某一个时，无论对手选择什么，我都能赢，
	 * 就表示能赢
	 * @param n
	 * @return
	 */
	public boolean canWinNim(int n) {
		boolean[] dp = new boolean[6];
		dp[0] = true;
		dp[1] = true;
		dp[2] = true;
		dp[3] = false;
		dp[4] = true;
		dp[5] = true;
		if (n < 7) {
			return dp[n - 1];
		}
		int currentInsertIndex = 0;
		for (int i = 7; i < n + 1; i++) {
			int backTwo = index(2, currentInsertIndex);
			int backThree = index(3, currentInsertIndex);
			int backFour = index(4, currentInsertIndex);
			int backFive = index(5, currentInsertIndex);
			int backSix = index(6, currentInsertIndex);
			boolean temp = (dp[backTwo] && dp[backThree] && dp[backFour])
					|| (dp[backThree] && dp[backFour] && dp[backFive])
					|| (dp[backFour] && dp[backFive] && dp[backSix]);
			dp[currentInsertIndex] = temp;
			currentInsertIndex = ++currentInsertIndex % 6;
		}
		return dp[index(1, currentInsertIndex)];
	}
    
    private int index(int backNum, int currentInsertIndex) {
		int result = currentInsertIndex - backNum;
		if (result >= 0) {
			return result;
		} else {
			return 6 + result;
		}
	}
    
    public static void main(String[] args) {
		NimGame3 nimGame = new NimGame3();
		System.out.println(nimGame.canWinNim(1348820612));
	}
}
