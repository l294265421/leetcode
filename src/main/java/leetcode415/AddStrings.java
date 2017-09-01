package leetcode415;

/**
 * 
Given two non-negative integers num1 and num2 represented as string, return the sum 
of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * @author liyuncong
 *
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        if (num1.length() < num2.length()) {
			String temp = num2;
			num2 = num1;
			num1 = temp;
		}
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0; i--, j--) {
        	int sum = Integer.parseInt(num1.substring(i, i + 1)) + carry;
        	if (j >= 0) {
    			sum += Integer.parseInt(num2.substring(j, j + 1));
			}
        	result.append(sum % 10);
        	carry = sum / 10;
        }
        if (carry != 0) {
			result.append(carry);
		}
        return result.reverse().toString();
    }
    
    public static void main(String[] args) {
		AddStrings addStrings = new AddStrings();
		System.out.println(addStrings.addStrings("125", "2266"));
	}
}
