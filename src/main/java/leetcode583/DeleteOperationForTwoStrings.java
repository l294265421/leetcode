package leetcode583;

/**

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:

Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Note:

    The length of given words won't exceed 500.
    Characters in given words can only be lower-case letters.

 * @author liyuncong
 *
 */
public class DeleteOperationForTwoStrings {
	/**
	 * 动态规划：
	 * 状态 minDistance(word1, word2)
	 * 状态转移 min(minDistance(word1 - 1, word2), minDistance(word1, word2 - 1), minDistance(word1 - 1, word2 -1))
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
			return 0;
		}
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] minDistanceMatrix = new int[len1 + 1][len2 + 1];
        for(int j = 0; j < len2 + 1; j++) {
        	minDistanceMatrix[0][j] = j;
        }
        for(int i = 0; i < len1 + 1; i++) {
        	minDistanceMatrix[i][0] = i;
        }
        for(int i = 1; i < len1 + 1; i++) {
        	for(int j = 1; j < len2 + 1; j++) {
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        			minDistanceMatrix[i][j] = minDistanceMatrix[i - 1][j - 1];
				} else {
					minDistanceMatrix[i][j] = Math.min(minDistanceMatrix[i - 1][j], minDistanceMatrix[i][j - 1]) + 1;
				}
        	}
        }
        return minDistanceMatrix[len1][len2];
    }
    
    public static void main(String[] args) {
		DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
		String word1 = "sea";
		String word2 = "eat";
		System.out.println(deleteOperationForTwoStrings.minDistance(word1, word2));
	}
}
