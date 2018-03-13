package leetcode796;

/**
 * 
We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the 
rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after 
one shift on A. Return True if and only if A can become B after some number of 
shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false

Note:

    A and B will have length at most 100.


 * @author liyuncong
 *
 */
public class RotateString {
	/**
	 * 可以先对A全部旋转，然后选定一个分界点，分别旋转前后两部分，然后对比旋转后的A和B是否相等
	 * @param A
	 * @param B
	 * @return
	 */
    public boolean rotateString(String A, String B) {
        if (A == null || B == null) {
			throw new NullPointerException();
		}
        if (A.length() == 0 || B.length() == 0) {
			throw new IllegalArgumentException();
		}
        if (A.length() != B.length()) {
			return false;
		}
        char[] a = A.toCharArray();
        char[] aCopy = a.clone();
        rotateArray(aCopy, 0, aCopy.length - 1);
        char[] b = B.toCharArray();
        for(int i = 0; i < a.length; i++) {
        	char[] aCopyCopy = aCopy.clone();
        	rotateArray(aCopyCopy, aCopyCopy.length - i, aCopyCopy.length - 1);
        	rotateArray(aCopyCopy, 0, aCopyCopy.length - i - 1);
        	if (arrayEqual(aCopyCopy, b)) {
				return true;
			}
        }
        return false;
    }
    
    public boolean arrayEqual(char[] a, char[] b) {
		for(int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
    
    public void rotateArray(char[] A, int start, int end) {
    	// 可以理解为一个递归的过程，每次迭代，都完成两边元素的颠倒，接下来需要旋转剩下的子数组
		while (start < end) {
			char temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++;
			end--;
		}
	}
    
    public static void main(String[] args) {
		RotateString rotateString = new RotateString();
		System.out.println(rotateString.rotateString("abcde", "cdeab"));
		System.out.println(rotateString.rotateString("abcde", "abced"));
	}
}
