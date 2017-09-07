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
public class ArrangingCoins2 {
    public int arrangeCoins(int n) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n) 
            	low = mid+1;
            else 
            	high = mid-1;
        }
        return low-1;
    }
    
    public static void main(String[] args) {
		ArrangingCoins2 arrangingCoins = new ArrangingCoins2();
		System.out.println(arrangingCoins.arrangeCoins(5));
	}
}
