package leetcode335;

public class LeetCode1351 {
	public boolean isSelfCrossing(int[] x) {
		int  len = x.length;
		if (len < 4) {
			return false;
		}
		
		if (len >= 4 && x[2] <= x[0] && x[3] >= x[1]) {
			return true;
		}
		
		// 状态1. 往外转
		// 状态2. 往里转
		// 往外转能够在某一时刻转为往里转，但是往里转不能转为往外转
		// 这是表明下次移动应该的状态
		int stats = 1;
		if (len >= 5) {
			if (x[3] <= x[1]) {
				stats = 2;
				if (x[3] == x[1] && x[4] >= x[2] - x[0]) {
					return true;
				} else if(x[3] < x[1] && x[4] > x[2]){
					return true;
				}
			}
			
			if (x[4] < x[2] - x[0]) {
				stats = 2;
			}
		}
		
		// len大于5
		for(int i = 5; i < len; i++) {
			// 检查之前的状态，1可能变为2，2只能继续为2
			if (stats == 1) {
				if (x[i - 1] <= x[i - 3]) {
					// 两种相交情况之一
					if (x[i - 1] >= x[i - 3] - x[i - 5] && x[i] >= x[i - 2] - x[i -4]) {
						return true;
					}
					
					// 两种相交情况之二
					if (x[i - 1] < x[i - 3] - x[i - 5] && x[i] >= x[i - 2]) {
						return true;
					}
					
					// 判断是否改变状态
					if (x[i] < x[i - 2] - x[i - 4]) {
						stats = 2;
					}
				}
			}
			
			if (stats == 2) {
				if (x[i] >= x[i - 2]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		LeetCode1351 leetCode1351 = new LeetCode1351();
		int[] x = new int[] {1,1,2,2,1,1};
		System.out.println(leetCode1351.isSelfCrossing(x));
	}
}
