package leetcode187;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

 * @author yuncong
 *
 */
public class LeetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new LinkedList<String>();
        if (s == null) {
			return result;
		}
        
        int len = s.length();
        if (len < 10) {
			return result;
		}
        
        // 统计
        Map<String, Integer> sequenceCount = new HashMap<String, Integer>();
        int upBound = len - 10 + 1;
        for (int i = 0; i < upBound; i++) {
			String sequence = s.substring(i, i + 10);
			if (sequenceCount.containsKey(sequence)) {
				sequenceCount.put(sequence, sequenceCount.get(sequence) + 1);
			} else {
				sequenceCount.put(sequence, 1);
			}
		}
        
        // 筛选
        for (Map.Entry<String, Integer> entry : sequenceCount.entrySet()) {
			if (entry.getValue() > 1) {
				result.add(entry.getKey());
			}
		}
        
        return result;
    }
}
