package leetcode263;

/**
 * 
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. 
 * @author liyuncong
 *
 */
public class UglyNumber {
    public boolean isUgly(int num) {
    	if (num < 1) {
			return false;
		}
    	if (num == 1) {
			return true;
		}
    	
    	return strategy2(num);
    }
    
    public boolean strategy1(int num) {
        if (num == 2 || num == 3 || num == 5) {
			return true;
		}
        
        if (num % 2 == 0) {
			return strategy1(num / 2);
		} else if (num % 3 == 0) {
			return strategy1(num / 3);
		} else if (num % 5 == 0) {
			return strategy1(num / 5);
		} else {
			return false;
		}
	}
    
    public boolean strategy2(int num) {
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
    
    public static void main(String[] args) {
		UglyNumber uglyNumber = new UglyNumber();
		System.out.println(uglyNumber.isUgly(4));
	}
}
