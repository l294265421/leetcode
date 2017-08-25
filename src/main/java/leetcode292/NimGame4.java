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
public class NimGame4 {
	/**
	 * https://discuss.leetcode.com/topic/27109/one-line-o-1-solution-and-explanation/2
	 * @param n
	 * @return
	 */
	public boolean canWinNim(int n) {
		return (n % 4 != 0);
	}
    
    public static void main(String[] args) {
		NimGame4 nimGame = new NimGame4();
		System.out.println(nimGame.canWinNim(1348820612));
	}
}
