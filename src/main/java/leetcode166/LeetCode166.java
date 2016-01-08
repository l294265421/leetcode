package leetcode166;

import java.util.HashMap;

public class LeetCode166 {
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0)
			return "";
		StringBuilder str = new StringBuilder();
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		if ((numerator < 0 && denominator > 0) || (numerator > 0
				&& denominator < 0)) {
			str.append('-');
		}
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		long n = num / den;
		long reminder = num % den;
		str.append(n);
		if (reminder == 0){
			return str.toString();
		} else {
			str.append('.');
		}
		// 余数一样，两余数（不包含后一个余数）之间产生的商就是循环部分
		do {
			// 存储该余数和由它产生的商在str中的位置
			map.put(reminder, str.length());
			// 商
			n = reminder * 10 / den;
			str.append(n);
			// 新的余数
			reminder = reminder * 10 % den;
			// 包含余数，说明循环找到了；余数为0，说明除尽了
		} while(!map.containsKey(reminder) && reminder != 0);
			
		if (reminder != 0) {
			str.insert(map.get(reminder), "(");
			str.append(')');
		}
		return str.toString();
	}
}
