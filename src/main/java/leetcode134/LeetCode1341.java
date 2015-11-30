package leetcode134;

public class LeetCode1341 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// 如果所有的油比跑完全程需要的油少，就不能走完全程，
		// 否则就一定存在一个起点，从这里出发，可以走完全程(有待证明)
		int len = gas.length;
		int surplusTotal = 0;
		for(int i = 0; i < len; i++) {
			surplusTotal += gas[i] - cost[i];
		}
		if (surplusTotal < 0) {
			return -1;
		}
		
		// 已经确定我们有足够的油走完全程了，现在就来寻找一个起点，
		// 这个起点是0,1...len-1中的一个；在这个环形中，选择不同
		// 的起点出发，n-1之后的部分都是一样，不一样的只是n-1及之前
		// 的部分，很容易理解，当这不一样的前缀部分剩余的油量越大时，
		// 在后面一样的部分就走得越远，这时这部分的起点就是最优起点；
		// 这时，问题抽象为寻找这个数组中以n-1结尾以那一点开始的一段
		// 路程前缀的后最大；我们知道，去掉数组中和为负的前缀，使前缀
		// 增大，去掉数组中和为正的前缀，使前缀减小，基于这一认识，我们
		// 来实现剩下的部分;
		//　这里强调的是这样一个思想：从出发点开始的某一段，剩余量越大，
		// 越能跨国一些坑（靠自身的油不能走到下一点的点），极限情况就是
		// 所有油都在起点
		int start = 0;
		int prefixSum = 0;
		for(int i = 0; i < len; i++) {
			int surplus = gas[i] - cost[i];
			if (prefixSum + surplus < 0) {
				start = i + 1;
				prefixSum = 0;
			} else {
				prefixSum += surplus;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		LeetCode1341 leetCode134 = new LeetCode1341();
		int[] gas = new int[] {4};
		int[] cost = new int[]{5};
		System.out.println(leetCode134.canCompleteCircuit(gas, cost));
	}
}
