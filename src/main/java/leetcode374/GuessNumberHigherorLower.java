package leetcode374;

/**
 * 
 We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 * 
 * -1 : My number is lower 1 : My number is higher 0 : Congrats! You got it!
 * 
 * Example:
 * 
 * n = 10, I pick 6.
 * 
 * Return 6.
 * 
 * The guess API is defined in the parent class GuessGame.
 * 
 * @param num
 *            , your guess
 * @return -1 if my number is lower, 1 if my number is higher, otherwise return
 *         0 int guess(int num);
 * 
 * @author yuncong
 *
 */
public class GuessNumberHigherorLower {
	private int picked;

	public GuessNumberHigherorLower(int picked) {
		super();
		this.picked = picked;
	}

	public int guessNumber(int n) {
		return strategy2(n);
	}

	/**
	 * 递归、二叉猜
	 * Line 26: java.lang.StackOverflowError
	 * @param low
	 * @param up
	 * @param guessNumber
	 * @return 猜中的数
	 */
	public int strategy1(int low, int up, int guessNumber) {
		int result = guess(guessNumber);
		if (result == 0) {
			return guessNumber;
		} else if (result == -1) {
			return strategy1(low, guessNumber - 1, (low + guessNumber - 1) / 2);
		} else {
			return strategy1(guessNumber + 1, up, (guessNumber + 1 + up) / 2);
		}
	}

	public int guess(int num) {
		if (num == picked) {
			return 0;
		} else if (num > picked) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public int strategy2(int n) {
		int low = 1;
		int up = n;
		int guessNumber;
		int guessResult;
		do {
			guessNumber = computeGuessNumber(low, up);
			guessResult = guess(guessNumber);
			if (guessResult == -1) {
				up = guessNumber -1;
			} else if (guessResult == 1) {
				low = guessNumber + 1;
			}
			
		} while (guessResult != 0);
		return guessNumber;
	}
	
	private int computeGuessNumber(long low, long up) {
		long sum = low + up;
		int result = (int) (sum / 2);
 		return result;
	}

	public static void main(String[] args) {
		GuessNumberHigherorLower guessNumberHigherorLower = new GuessNumberHigherorLower(1702766719);
		System.out.println(guessNumberHigherorLower.guessNumber(2126753390));
	}
}
