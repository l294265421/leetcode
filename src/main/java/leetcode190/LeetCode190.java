package leetcode190;

/**
 * 
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it? 
Related problem: {@link leetcode7.LeetCode7}}
 * @author liyuncong
 *
 */
public class LeetCode190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	String binaryRepresentation = toBinaryString(n);
    	int len = binaryRepresentation.length();
    	int minus = 32 - len;
    	binaryRepresentation = addleadingZero(binaryRepresentation, minus);
    	String resultBinaryRepresentation = reverseString(binaryRepresentation);
        return (int) Long.parseLong(resultBinaryRepresentation, 2);
    }
    
    private String reverseString(String s) {
    	if (s == null) {
			return "";
		}
    	
    	StringBuilder stringBuilder = new StringBuilder();
    	int len = s.length();
    	for(int i = len - 1; i >= 0; i--) {
    		stringBuilder.append(s.charAt(i));
    	}
    	return stringBuilder.toString();
    }
    
    /**
     * 
     * @param s 字符
     * @param num 需要加前导0的个数
     * @return
     */
    public String addleadingZero(String s, int num) {
		for (int i = 0; i < num; i++) {
			s = "0" + s;
		}
		return s;
	}
    
    /**
     * All possible chars for representing a number as a String
     */
    final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
    
    /**
     * Convert the integer to an unsigned number.
     */
    private static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = digits[i & mask];
            i >>>= shift;
        } while (i != 0);

        return new String(buf, charPos, (32 - charPos));
    }
    
    /**
     * Returns a string representation of the integer argument as an
     * unsigned integer in base&nbsp;2.
     *
     * <p>The unsigned integer value is the argument plus 2<sup>32</sup>
     * if the argument is negative; otherwise it is equal to the
     * argument.  This value is converted to a string of ASCII digits
     * in binary (base&nbsp;2) with no extra leading {@code 0}s.
     * If the unsigned magnitude is zero, it is represented by a
     * single zero character {@code '0'}
     * (<code>'&#92;u0030'</code>); otherwise, the first character of
     * the representation of the unsigned magnitude will not be the
     * zero character. The characters {@code '0'}
     * (<code>'&#92;u0030'</code>) and {@code '1'}
     * (<code>'&#92;u0031'</code>) are used as binary digits.
     *
     * @param   i   an integer to be converted to a string.
     * @return  the string representation of the unsigned integer value
     *          represented by the argument in binary (base&nbsp;2).
     * @since   JDK1.0.2
     */
    public static String toBinaryString(int i) {
        return toUnsignedString(i, 1);
    }
    
    public static void main(String[] args) {
    	LeetCode190 leetCode190 = new LeetCode190();
		System.out.println(leetCode190.reverseBits(1));
	}
}
