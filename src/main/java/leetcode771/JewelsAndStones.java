package leetcode771;

/**
 * 
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:

Input: J = "z", S = "ZZ"
Output: 0

Note:

    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.

 * @author liyuncong
 *
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
    	if (J == null || S == null || J.length() == 0 || S.length() == 0) {
			return 0;
		}
        int[] charHashTable = new int[256];
        for(int i = 0; i < J.length(); i++) {
        	charHashTable[J.charAt(i)] = 1;
        }
        int result = 0;
        for(int i = 0; i < S.length(); i++) {
        	if (charHashTable[S.charAt(i)] == 1) {
				result++;
			}
        }
        return result;
    }
    
    public static void main(String[] args) {
		JewelsAndStones jewelsAndStones = new JewelsAndStones();
		String J = "aA", S = "aAAbbbb";
		System.out.println(jewelsAndStones.numJewelsInStones(J, S));
	}
}
