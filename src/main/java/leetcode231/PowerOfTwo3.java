package leetcode231;

/**
 * 
 * Given an integer, write a function to determine if it is a power of two. 
 * @author liyuncong
 *
 */
public class PowerOfTwo3 {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;

//		10
//		1
//		100
//		11
//		1000
//		111
//		10000
//		1111
//		100000
//		11111
		// 同样存在疑问，怎么证明其它数会不会也有这种情况？
		return ((n & (n - 1)) == 0);
	}
    
    public static void main(String[] args) {
		PowerOfTwo3 powerOfTwo = new PowerOfTwo3();
		System.out.println(powerOfTwo.isPowerOfTwo(1073741825));
	}
}
