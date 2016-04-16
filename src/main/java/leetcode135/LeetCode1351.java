package leetcode135;

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
		int stats = 1;
		if (len >= 5) {
			if (x[3] <= x[1]) {
				stats = 2;
				if (x[3] == x[1] && x[4] >= x[2] - x[1]) {
					return true;
				} else if(x[3] < x[1] && x[4] > x[2]){
					return true;
				}
			}
		}
		
		// len大于五的情况
		for(int i = 5; i < len; i++) {
			
		}
	}
}
