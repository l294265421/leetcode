package leetcode264;

/**
 * 
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 
3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number. 
 * @author liyuncong
 *
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
    	return strategy2(n);
    }
    
    public int strategy1(int n) {
        int result = 1;
        int count = 0;
        for(int i = 1; i <= Integer.MAX_VALUE; i++) {
        	if (isUgly(i)) {
				count++;
				if (count == n) {
					result = i;
					break;
				}
			}
        }
        return result;
	}
    
    public boolean isUgly(int num) {
    	if (num < 1) {
			return false;
		}
    	if (num == 1) {
			return true;
		}
    	
		while (true) {
	        if (num == 2 || num == 3 || num == 5) {
				return true;
			}
	        
	        if (num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				return false;
			}
		}
    }
    
    /**
     * The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to 
split the sequence to three groups as below:

(0) 1×1, 2×1, 3×1, 4×1, 5×1, …
(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …

We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …)(并不是1, 2, 3,
4, 5, 6, 7, 而是1, 2, 3, 4, 5, 6, 8,) multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.
（怎么证明序列(1) (2) (3)合并起来包含所有ugly number？）

Every step we choose the smallest one, and move one step after,including nums with same value.

Thanks for this author about this brilliant idea. Here is my java solution
     * @param n
     * @return
     */
    public int strategy2(int n) {
    	 int[] ugly = new int[n];
         ugly[0] = 1;
         // 2 3 5 应该乘ugly number序列中的哪个位置的元素了，用于获得分解后三个序列中相应位置的值
         int index2 = 0;
         int index3 = 0; 
         int index5 = 0;
         int factor2 = 2;
         int factor3 = 3;
         int factor5 = 5;
         for(int i=1; i<n; i++){
             int min = Math.min(Math.min(factor2,factor3),factor5);
             ugly[i] = min;
             // 同一个最小值只会取一次
             if(factor2 == min) {
            	 factor2 = 2*ugly[++index2];
             }
             if(factor3 == min) {
            	 factor3 = 3*ugly[++index3];
             }
             if(factor5 == min) {
            	 factor5 = 5*ugly[++index5];
             }
         }
         return ugly[n-1];
	}
    
    public static void main(String[] args) {
		UglyNumberII uglyNumberII = new UglyNumberII();
		System.out.println(uglyNumberII.nthUglyNumber(1352));
	}
}
