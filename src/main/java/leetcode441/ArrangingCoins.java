package leetcode441;

/**
 * 
You have a total of n coins that you want to form in a staircase shape, where every 
k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

 * @author liyuncong
 *
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        // 1 + 2 + ... + result < n
    	long result = 0;
    	long start = 0;
    	long end = n;
    	while (start <= end) {
			long mid = start + (end - start) / 2;
			long coinNum = (1 + mid) * mid / 2;
			if (coinNum < n) {
				start = mid + 1;
				result = mid;
			} else if (coinNum > n) {
				end = mid - 1;
				result = end;
			} else {
				result = mid;
				break;
			}
		}
    	return (int) result;
    }
    
    public static void main(String[] args) {
		ArrangingCoins arrangingCoins = new ArrangingCoins();
		System.out.println(arrangingCoins.arrangeCoins(5));
	}
}
