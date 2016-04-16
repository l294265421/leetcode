package leetcode335;

public class LeetCode135 {
	public boolean isSelfCrossing (int[] x) 
	{ 

	    if (x.length < 4)
	        return false;

	    for (int i = 3 ; i < x.length ; i++) {
	        if (isCrossing_2(x, i)) {
	            return true;
	        }

	        if (i > 4 && isCrossing_4(x, i))
	            return true;

	        if (i == 4 && x[i-1] == x[i-3] && x[i] >= x[i-2] - x[i-4])
	            return true;
	    }

	    return false;
	}
	
	/**
	 * Check crossing for last 2 movements along same direction；
	 * 比较上界
	 * @param x
	 * @param i
	 * @return
	 */
	public boolean isCrossing_2(int[] x, int i) {
	    if (x[i-1] <= x[i-3] && x[i] >= x[i-2])
	        return true;

	    return false;
	}
	
	/**
	 * Check crossing for last 4 movements along same direction；
	 * 比较下界
	 * @param x
	 * @param i
	 * @return
	 */
	public boolean isCrossing_4(int[] x, int i) {
	    if (x[i-1] <= x[i-3] && x[i-1] >= x[i-3] - x[i-5] && x[i-2] >= x[i-4] && x[i] >=  x[i-2] - x[i-4])
	        return true;

	    return false;
	}
	
	public static void main(String[] args) {
		int[] x = new int[] {10, 5, 8, 3, 11};
		System.out.println(new LeetCode135().isSelfCrossing(x));
	}
}
