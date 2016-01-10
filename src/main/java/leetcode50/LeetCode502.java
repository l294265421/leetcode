package leetcode50;

import java.util.LinkedList;

/**
 * 最简答的方法就是把n个x直接做乘法，但这样要进行(n-1)次运算。现在以2**8(表示2的8次方)作为例子，
 * 需要进行7次乘法，但如果当做(2**2)**4->((2**2)**2)**2来计算就只要做3次乘法。即，当n为
 * 偶数时，x^n == (x^2)^(n/2);当n为奇数时，x^n == x * x^(n-1)。当n为负数时要取倒数。
 * @author yuncong
 *
 */
public class LeetCode502 {
    public double myPow(double x, int n) {
        if (n == 0) {
			return 1;
		}
        
        boolean isDaoshu = false;
        //n为 Integer.MIN_VALUE没有相反数的情况
        long newn = n;
        if (newn < 0) {
			isDaoshu = true;
			newn = -newn;
		}
        
        double newx = x;
        // 模拟递归实现
        // 记录下操作
        LinkedList<Double> stack = new LinkedList<Double>();
        // n表示的newx的多少次方，而不是还要乘多少x
        while (newn > 1) {
			if (newn % 2 == 0) {
				newn = newn / 2;
				newx = newx * newx;
				// 返回时不用做任何操作
				stack.push(1.0);
			} else {
				newn = newn - 1;
				// 返回时乘以x
				stack.push(newx);
			}
		}
        while (!stack.isEmpty()) {
			double top = stack.pop();
			newx *= top;
		}
        
        if (isDaoshu) {
        	newx = 1 / newx;
		}
        return newx;
    }
    
    public static void main(String[] args) {
		LeetCode502 leetCode50 = new LeetCode502();
		System.out.println(leetCode50.myPow(-1.00000,
				-2147483646));
		System.out.println(Integer.MIN_VALUE);
	}
}
