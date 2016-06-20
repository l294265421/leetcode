package leetcode349;

import java.util.HashSet;
import java.util.Set;

import leetcode190.LeetCode190;

/**
 * 
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.

 * @author liyuncong
 *
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null) {
			 return new int[0];
		}
        int len1 = nums1.length;
        if (len1 == 0) {
			return new int[0];
		}
        if (nums2 == null) {
			return new int[0];
		}
        int len2 = nums2.length;
        if (len2 == 0) {
			return new int[0];
		}
        
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0; i < len1; i++) {
        	set1.add(nums1[i]);
        }
        
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < len2; i++) {
			set2.add(nums2[i]);
		}
        Set<Integer> resultSet = new HashSet<>();
        for (Integer e : set1) {
			if (set2.contains(e)) {
				resultSet.add(e);
			}
		}
        int size = resultSet.size();
        if (size == 0) {
			return new int[0];
		}
        int[] result = new int[size];
        int count = 0;
        for (int i : resultSet) {
			result[count] = i;
			count++;
		}
        return result;
    }
    
    public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 2, 1};
		int[] nums2 = new int[] {2, 2};
		IntersectionofTwoArrays intersectionofTwoArrays = new IntersectionofTwoArrays();
		int[] result = intersectionofTwoArrays.intersection(nums1, nums2);
		if (result == null) {
			return;
		}
		for (int i : result) {
			System.out.println(i);
		}
	}
}
