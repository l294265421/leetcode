package leetcode151;

public class LeetCode151 {
    public String reverseWords(String s) {
        s = s.trim();
        // 把两个及两个以上连续的空格换为一个
        s = s.replaceAll(" {2,}", " ");
        String[] words = s.split(" ");
        reverse(words);
        String result = "";
        for (String word : words) {
			result += word + " ";
		}
        return result.trim();
    }
    
    /**
     * 反转字符串数组
     * @param strings
     */
    public void reverse(String[] strings) {
		int len = strings.length;
		if (len < 2) {
			return;
		}
		int half = len / 2;
		for(int i = 0; i < half; i++) {
			String temp = strings[i];
			strings[i] = strings[len - 1 - i];
			strings[len - 1 - i] = temp;
		}
	}
    
    public static void main(String[] args) {
		LeetCode151 leetCode151 = new LeetCode151();
		System.out.println(leetCode151.reverseWords("   a   b "));
	}
}
