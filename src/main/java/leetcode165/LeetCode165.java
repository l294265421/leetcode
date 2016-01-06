package leetcode165;

public class LeetCode165 {
	public int compareVersion(String version1, String version2) {
		int[] version1Component;
		int len1 = 0;
		if (version1.indexOf('.') == -1) {
			len1 = 1;
			version1Component = new int[] 
					{Integer.valueOf(version1)};
		} else {
			String[] temp = version1.split("\\.");
			int len = temp.length;
			len1 = len;
			version1Component = new int[len];
			for (int i = 0; i < len; i++) {
				version1Component[i] = Integer.valueOf(temp[i]);
			}
			
		}
		
		int[] version2Component;
		int len2 = 0;
		if (version2.indexOf('.') == -1) {
			len2 = 1;
			version2Component = new int[] 
					{Integer.valueOf(version2)};
		} else {
			String[] temp = version2.split("\\.");
			int len = temp.length;
			len2 = len;
			version2Component = new int[len];
			for (int i = 0; i < len; i++) {
				version2Component[i] = Integer.valueOf(temp[i]);
			}
			
		}
		int len = Math.min(len1, len2);
		for (int i = 0; i < len; i++) {
			int temp1 = version1Component[i];
			int temp2 = version2Component[i];
			if (temp1 > temp2) {
				return 1;
			} else if (temp1 < temp2) {
				return -1;
			}
		}
		if (len1 == len2) {
			return 0;
		}
		// 前面的都相等,需要处理长数组后面的内容
		if (len == len1) {
			for(int i = len; i < len2; i++) {
				if (version2Component[i] != 0) {
					return -1;
				}
			}
		} else {
			for(int i = len; i < len1; i++) {
				if (version1Component[i] != 0) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String version1 = "1";
		String version2 = "1.1";
		LeetCode165 leetCode165 = new LeetCode165();
		System.out.println(leetCode165.compareVersion(version1, version2));
	}
}
