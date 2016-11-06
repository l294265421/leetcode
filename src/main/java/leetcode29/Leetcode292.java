package leetcode29;
/**
 * 
 *  29. Divide Two Integers

	Divide two integers without using multiplication, division and mod operator.

	If it is overflow, return MAX_INT. 
	
	解答：
	a / b = x，x是一个正数，x可以表示成二进制数，也就是x==a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n,
	其中，a_0到a_n只能是0或者1，可以通过移位操作和减法操作得到x的这个表达式中的值，最后得到答案。
	
 * @author yuncong
 *
 */
public class Leetcode292 {
	public int divide(int dividend, int divisor) {
	    if(divisor == 0)
	    {
	        return Integer.MAX_VALUE;
	    }
	    // 比较符号位是否相同
	    boolean isNeg = (dividend^divisor)>>>31 == 1;
	    int res = 0;
	    if(dividend == Integer.MIN_VALUE)
	    {
	        dividend += Math.abs(divisor);
	        if(divisor == -1)
	        {
	            return Integer.MAX_VALUE;
	        }
	        res++;
	    }
	    if(divisor == Integer.MIN_VALUE)
	    {
	        return res;
	    }
	    dividend = Math.abs(dividend);
	    divisor = Math.abs(divisor);
	    int digit = 0;
	    // 获得 divisor * 2^n < dividend最大那个n
	    while(divisor <= (dividend>>1))
	    {
	        divisor <<= 1;
	        digit++;
	    }
	    while(digit>=0)
	    {
	        if(dividend>=divisor)
	        {
	            res += 1<<digit;
	            dividend -= divisor;
	        }
	        divisor >>= 1;
	        digit--;
	    }
	    return isNeg?-res:res;
	}
	
	public static void main(String[] args) {
		System.out.println(-128 >>> 2);
		System.out.println(-128 >> 2);
		System.out.println(-128 << 2);
	}
}
