package leetcode592;

/**
 * 
Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

Example 1:

Input:"-1/2+1/2"
Output: "0/1"

Example 2:

Input:"-1/2+1/2+1/3"
Output: "1/3"

Example 3:

Input:"1/3-1/2"
Output: "-1/6"

Example 4:

Input:"5/3+1/3"
Output: "2/1"

Note:

    The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
    Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
    The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
    The number of given fractions will be in the range [1,10].
    The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

 * @author liyuncong
 *
 */
public class FractionAdditionAndSubtraction {
	/**
	 *思路：
	 *（1）每遇见一个就加一个（分数相加）
	 *（2）每加一个就化简
	 * @param expression
	 * @return
	 */
    public String fractionAddition(String expression) {
    	if (expression == null || expression.length() == 0) {
			return "";
		}
    	String last = "";
    	if (expression.charAt(1) == '-') {
			expression = "+" + expression;
		}
    	do {
			int thisPartPlusIndex = expression.indexOf('+', 1);
			int thisPartMinusIndex = expression.indexOf('-', 1);
			String thisPart;
			if (thisPartMinusIndex == -1 && thisPartPlusIndex == -1) {
				thisPart = expression;
				expression = "";
			} else if (thisPartMinusIndex == -1) {
				thisPart = expression.substring(0, thisPartPlusIndex);
				expression = expression.substring(thisPartPlusIndex);
			} else if (thisPartPlusIndex == -1) {
				thisPart = expression.substring(0, thisPartMinusIndex);
				expression = expression.substring(thisPartMinusIndex);
			} else {
				thisPart = expression.substring(0, Math.min(thisPartPlusIndex, thisPartMinusIndex));
				expression = expression.substring(Math.min(thisPartPlusIndex, thisPartMinusIndex));
			}
			if ("".equals(last)) {
				last = thisPart;
			} else {
				last = plus(last, thisPart);
			}
		} while (expression.length() != 0);
        return last;
    }
    
    public String plus(String fraction1, String fraction2) {
    	String[] fraction1Parts = fraction1.split("/");
    	int numerator1 = Integer.parseInt(fraction1Parts[0]);
    	int denominator1 = Integer.parseInt(fraction1Parts[1]);
    	String[] fraction2Parts = fraction2.split("/");
    	int numerator2 = Integer.parseInt(fraction2Parts[0]);
    	int demominator2 = Integer.parseInt(fraction2Parts[1]);
    	int leastCommonMultiple = leastCommonMultiple(denominator1, demominator2);
    	int multiple1 = leastCommonMultiple / denominator1;
    	int multiple2 = leastCommonMultiple / demominator2;
    	numerator1 *= multiple1;
    	numerator2 *= multiple2;
    	int resultNumerator = numerator1 + numerator2;
    	if (resultNumerator == 0) {
			return "0/1";
		}
    	int temp = resultNumerator;
    	if (resultNumerator < 0) {
			temp *= -1;
		}
    	int greatestCommonDivisior;
    	if (resultNumerator > leastCommonMultiple) {
			greatestCommonDivisior = greatestCommonDivisior(temp, leastCommonMultiple);
		} else {
			greatestCommonDivisior = greatestCommonDivisior(leastCommonMultiple, temp);
		}
    	return resultNumerator / greatestCommonDivisior + "/" + leastCommonMultiple / greatestCommonDivisior;
	}
    
    /**
     * 
欧几里得算法:
假设我们的最大公约数表示为f(a,b),并且有a>=b>0,
欧几里德就给了我们一个很好的定理，f(a,b)=f(b,a%b),有了这个等式我们就很容易得出这个算法的递归式，现在我们来看下这个等式是怎么来的。

设有 r=a/b ,q=a%b  
所以就有 a=a/b*b+q(这里的a/b*b!=a，原因就是我们用的是整数来计算的)
也就是a=r*b+q，变换一下有：q=a-r*b 
设d=f(a,b)，a/d=m,b/d=n;则有q=dm-r*dn=d(m-rn)，所以q%d也为0；
(上面用于证明d也是q的约数)

设d|q表示d是q的约数；以下相同；
又有d|b;所以有d|(b,q),设D是(b,q)的最大公约数，则会有d<=D=f(b,q);

再回到前面r=a/b,q=a%b这两个条件，有a=r*b+q,由于D|(b,q),所以D|a,所以有D|(a,b)
所以有D<=d=f(a,b),结合上部分就有d<=D<=d,及D=d;
     * @return
     */
	public int greatestCommonDivisior(int a, int b) {
		if (a < b) {
			int temp;
			temp = a;
			a = b;
			b = temp;
		}
		if (0 == b) {
			return a;
		}
		return greatestCommonDivisior(b, a % b);
	}
    
    /**
     * 最小公倍数
     * @return
     */
    public int leastCommonMultiple(int x, int y) {
        int z;  
        for(z=x;;z++){  
            if(z%x==0&&z%y==0){  
                break;  
            }  
        }  
        return z;  
	}
    
    public static void main(String[] args) {
		FractionAdditionAndSubtraction fractionAdditionAndSubtraction = new FractionAdditionAndSubtraction();
		String input = "-1/2+1/2+1/3";
		System.out.println(fractionAdditionAndSubtraction.fractionAddition(input));
	}
}
