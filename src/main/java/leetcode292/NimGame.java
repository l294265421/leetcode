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
public class NimGame {
	/**
	 * 我每次可以选择remove 1 2 3个，对手也可以，只要我选择某一个时，无论对手选择什么，我都能赢，
	 * 就表示能赢
	 * @param n
	 * @return
	 */
    public boolean canWinNim(int n) {
        if (n <= 3) {
			return true;
		}
        if (n == 4) {
			return false;
		}
        return (canWinNim(n - 1 - 1) && canWinNim(n - 1 - 2) && canWinNim(n - 1 -3))
        		|| (canWinNim(n - 2 - 1) && canWinNim(n - 2 - 2) && canWinNim(n - 2 -3))
        		||(canWinNim(n - 3 - 1) && canWinNim(n - 3 - 2) && canWinNim(n - 3 -3));
    }
    
    public static void main(String[] args) {
		NimGame nimGame = new NimGame();
		System.out.println(nimGame.canWinNim(8));
	}
}
