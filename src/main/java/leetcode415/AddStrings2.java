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
public class AddStrings2 {
    public String addStrings(String num1, String num2) {
        char[] a , b;
        if (num1.length() > num2.length()){
            a = num1.toCharArray();
            b = num2.toCharArray();
        } else{
            a = num2.toCharArray();
            b = num1.toCharArray();
        }
        char[] result = new char[a.length+1];
        int c = 0;
        for(int i = b.length - 1; i >= 0; i--){
            int x = a[i + a.length - b.length] - '0';
            int y = b[i] - '0';
            int r1 = (x + y + c)%10;
            result[i + a.length - b.length + 1] = (char)(r1 + '0');
            c = (x+y+c)/10;
        }
        for(int i = a.length - b.length - 1; i >= 0; i--){
            result[i + 1] = (char)((a[i] - '0' + c)%10 + '0');
            c = (a[i] - '0' + c)/10;
        }
        result[0] = (char)(c + '0');
        return (c == 0)?String.valueOf(result,1,a.length):String.valueOf(result);
    }
    
    public static void main(String[] args) {
		AddStrings2 addStrings = new AddStrings2();
		System.out.println(addStrings.addStrings("125", "2266"));
	}
}
