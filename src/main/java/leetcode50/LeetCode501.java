package leetcode50;

/**
 * 最简答的方法就是把n个x直接做乘法，但这样要进行(n-1)次运算。现在以2**8(表示2的8次方)作为例子，
 * 需要进行7次乘法，但如果当做(2**2)**4->((2**2)**2)**2来计算就只要做3次乘法。即，当n为
 * 偶数时，x^n == (x^2)^(n/2);当n为奇数时，x^n == x * x^(n-1)。当n为负数时要取倒数。
 * @author yuncong
 *
 */
public class LeetCode501 {
    public double myPow(double x, int n) {
        if (n == 0) {
			return 1;
		}
        
        boolean isDaoshu = false;
        if (n < 0) {
			isDaoshu = true;
			n = -n;
		}
        
        double result = myPow1(x, n);
        
        if (isDaoshu) {
			result = 1 / result;
		}
        return result;
    }
    
    /**
     * n大于0
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
			return 1;
		}

        double result = 0;
        if (n % 2 == 0) {
			result = myPow1(x * x, n / 2);
		} else {
			result = x * myPow1(x, n - 1);
		}
        return result;
    }
    
    public static void main(String[] args) {
		LeetCode501 leetCode50 = new LeetCode501();
		System.out.println(leetCode50.myPow(-1.00000,
				-2147483648));
	}
}
