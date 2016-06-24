package leetcode264;

/**
 * 
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number. 
 * @author liyuncong
 *
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
    	return strategy1(n);
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
    
    public int strategy(int n) {
        int[] a = new int[n];
        a[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            while (2 * a[p2] <= a[i - 1]) {
                p2++;
            }
            while (3 * a[p3] <= a[i - 1]) {
                p3++;
            }
            while (5 * a[p5] <= a[i - 1]) {
                p5++;
            }
            a[i] = Math.min(2 * a[p2], Math.min(3 * a[p3], 5 * a[p5]));
        }
        return a[n - 1];
	}
    
    public static void main(String[] args) {
		UglyNumberII uglyNumberII = new UglyNumberII();
		System.out.println(uglyNumberII.nthUglyNumber(1352));
	}
}
