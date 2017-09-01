package leetcode405;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 Given an integer, write an algorithm to convert it to hexadecimal. For negative 
 integer, two’s complement method is used.

Note:

    All letters in hexadecimal (a-f) must be in lowercase.
    The hexadecimal string must not contain extra leading 0s. If the number is zero, 
    it is represented by a single zero character '0'; otherwise, the first character 
    in the hexadecimal string will not be the zero character.
    The given number is guaranteed to fit within the range of a 32-bit signed integer.
    You must not use any method provided by the library which converts/formats the 
    number to hex directly.

Example 1:

Input:
26

Output:
"1a"

Example 2:

Input:
-1

Output:
"ffffffff"

 * @author liyuncong
 *
 */
public class ConvertANumberToHexadecimal {
	private char[] hexadecimalElement = new char[] {'0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	private Map<Character, String> charAndHex = new HashMap<>();
	{
		charAndHex.put('0', "0000");
		charAndHex.put('1', "0001");
		charAndHex.put('2', "0010");
		charAndHex.put('3', "0011");
		charAndHex.put('4', "0100");
		charAndHex.put('5', "0101");
		charAndHex.put('6', "0110");
		charAndHex.put('7', "0111");
		charAndHex.put('8', "1000");
		charAndHex.put('9', "1001");
		charAndHex.put('a', "1010");
		charAndHex.put('b', "1011");
		charAndHex.put('c', "1100");
		charAndHex.put('d', "1101");
		charAndHex.put('e', "1110");
		charAndHex.put('f', "1111");
	}
    public String toHex(int num) {
        if (num == 0) {
			return "0";
		} else if (num > 0) {
			return positiveToHex(num);
		} else {
			return negativeToHex(num);
		}
    }
    
    public String positiveToHex(int num) {
    	StringBuilder result = new StringBuilder();
        int power = 1;
        do {
			int remainder = (int) (num % Math.pow(16, power));
			result.append(hexadecimalElement[(int) (remainder / Math.pow(16, power - 1))]);
			num -= remainder;
			power++;
		} while (num > 0);
        return result.reverse().toString();
    }
    
    public String negativeToHex(int num) {
		num = num * -1;
		int[] result = new int[32];
		result[0] = 1;
		int position = 31;
		String positiveToHex = positiveToHex(num);
		for(int i = positiveToHex.length() - 1; i >=0; i--) {
			String charBinary = charAndHex.get(positiveToHex.charAt(i));
			for(int j = 3; j >= 0; j--) {
				result[position--] =Integer.parseInt(charBinary.substring(j, j + 1));
			}
		}
		
		// 求反码
		for(int i = 1; i < 32; i++) {
			if (result[i] == 0) {
				result[i] = 1;
			} else {
				result[i] = 0;
			}
		}
		
		// 求补码
		for(int i = 31; i > 0; i--) {
			if (result[i] == 0) {
				result[i] = 1;
				break;
			} else {
				result[i] = 0;
			}
		}
		return binaryToHex(result);
	}
    
    private String binaryToHex(int[] binary) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < 32; ) {
			int index = 0;
			for (int power = 3; power >= 0; power--) {
				index += Math.pow(2, power) * binary[i];
				i++;
			}
			result.append(hexadecimalElement[index]);
		}
		return result.toString();
	}
    
    public static void main(String[] args) {
		ConvertANumberToHexadecimal convertANumberToHexadecimal = new ConvertANumberToHexadecimal();
		System.out.println(convertANumberToHexadecimal.toHex(-2147483648));
		System.out.println(Integer.toHexString(-2147483648));
		System.out.println(Integer.MIN_VALUE);
	}
}
