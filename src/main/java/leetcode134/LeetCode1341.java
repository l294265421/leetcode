package leetcode134;

public class LeetCode1341 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		if (len == 0) {
			return -1;
		}

		int[] array = new int[len];
		for (int i = 0; i < len; i++) {
			array[i] = gas[i] - cost[i];
		}
		
		// 获得最大子序列的信息
		SubArrayDescription description = MaxSubSum(array);
		int surplus = description.surplus;
		if (surplus < 0) {
			return -1;
		}
		int start = description.start;
		int end = description.end;

		// 从end + 1开始，只要遇到一个跑不过的，就跑不过
		for (int i = 1; i < len; i++) {
			int position = (end + i) % len;
			if (position == start) {
				break;
			}
			surplus += array[position];
			if (surplus < 0) {
				return -1;
			}
		}
		
		if (end < start) {
			for (int i = end + 1; i < start; i++) {
				surplus += array[i];
				if (surplus < 0) {
					return -1;
				}
			}
		} else {
			for(int i = end + 1; i < len; i++) {
				surplus += array[i];
				if (surplus < 0) {
					return -1;
				}
			}
			for(int i = 0; i < start; i++) {
				surplus += array[i];
				if (surplus < 0) {
					return -1;
				}
			}
		}
		return start;
	}

	/**
	 * 计算全局最大子序列
	 * 
	 * @param array
	 *            存储着环的数组
	 * @return
	 */
	private SubArrayDescription MaxSubSum(int[] array) {
		int len = array.length;
		int maxSum = -1;
		int finalStart = -1;
		int finalEnd = -1;
		for (int i = 0; i < len; i++) {
			int end = -1;
			if (i == 0) {
				end = len - 1;
			} else {
				end = i - 1;
			}
			SubArrayDescription description = MaxSubSum(array,
					new SubArrayDescription(i, end, -1));
			int surplus = description.surplus;
			if (surplus == -1) {
				continue;
			} else {
				if (surplus > maxSum) {
					maxSum = surplus;
					finalStart = i;
					finalEnd = end;
				}
			}
		}
		return new SubArrayDescription(finalStart, finalEnd, maxSum);
	}

	/**
	 * 得到以description.end结尾的最大子序列的描述
	 * 
	 * @param array
	 *            存储着环的数组
	 * @param description
	 *            环的起点终点的描述
	 * @return
	 */
	private SubArrayDescription MaxSubSum(int[] array,
			SubArrayDescription description) {
		int start = description.start;
		int end = description.end;
		// 小于0的元素不可能作为全局最大子序列的终点
		if (array[end] < 0) {
			return new SubArrayDescription(-1, -1, -1);
		}

		int len = array.length;

		int newStart = start;
		int sum = 0;
		// 删除end的所有小于0的前缀
		for (int i = 0; i < len; i++) {
			// 当前元素在数组中的位置
			int position = (start + i) % len;
			int thisNum = array[position];
			sum = thisNum + sum;
			if (sum < 0) {
				sum = 0;
				newStart = (start + i + 1) % len;
			}
		}

		return new SubArrayDescription(newStart, end, sum);
	}

	/**
	 * 描述一个数组中的子序列
	 * 
	 * @author yuncong
	 * 
	 */
	private static class SubArrayDescription {
		// 子序列的起点
		private int start;
		// 子序列的终点
		private int end;
		// 子序列的和
		private int surplus;

		public SubArrayDescription(int start, int end, int surplus) {
			super();
			this.start = start;
			this.end = end;
			this.surplus = surplus;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getSurplus() {
			return surplus;
		}

		public void setSurplus(int surplus) {
			this.surplus = surplus;
		}

	}
	
	public static void main(String[] args) {
		LeetCode1341 leetCode134 = new LeetCode1341();
		int[] gas = new int[] {4};
		int[] cost = new int[]{5};
		System.out.println(leetCode134.canCompleteCircuit(gas, cost));
	}
}
