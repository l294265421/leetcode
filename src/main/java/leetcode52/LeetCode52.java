package leetcode52;

public class LeetCode52 {
	private int queenNum;
	// 位置索引表示行数，值表示列数
	private int[] queenArr;
	// 临时设置用于保存能成功摆放皇后的位置种数
	private int goodPositionNum;
	
    public int totalNQueens(int n) {
		this.queenNum = n;
		queenArr = new int[queenNum];
		for (int i = 0; i < queenNum; i++) {
			queenArr[i] = -1;
		}
		// 从第0行开始摆放皇后
		trial(0);
		return this.goodPositionNum;
    }
    
    /**
	 * 
	 * @param i 第几行
	 */
	public void trial(int i) {
		if (i == queenNum) {
			this.goodPositionNum++;
		} else {
			for(int j = 0; j < this.queenNum; j++) {
				if (this.judge(i, j)) {
					this.queenArr[i] = j;
					trial(i + 1);
				} else {
					continue;
				}
			}
		}
	}
	
	/**
	 * 判断把皇后放在第i行第j列是否安全；是通过
	 * 前面第i行前面各行中的皇后的摆放位置
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean judge(int i, int j) {
		// 判断在地j列是否已经摆放过皇后
		for(int k = 0; k < i; k++) {
			if (queenArr[k] == j) {
				return false;
			}
		}
		
		// 判断正对角线上是否已经摆放过皇后 
		for(int k = 0; k < i; k++) {
			if ((k + queenArr[k]) == (i + j)) {
				return false;
			}
		}
		
		// 判断反对角线上是否已经摆放了皇后
		for(int k = 0; k < i; k++) {
			if ((k - queenArr[k]) == (i - j)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LeetCode52 leetCode52 = new LeetCode52();
		System.out.println(leetCode52.totalNQueens(3));
	}
}
