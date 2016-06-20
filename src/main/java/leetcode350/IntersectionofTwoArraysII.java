package leetcode350;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 * @author liyuncong
 *
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
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
        
        List<Integer> list1 = new LinkedList<>();
        for(int i = 0; i < len1; i++) {
        	list1.add(nums1[i]);
        }
        
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < len2; i++) {
			list2.add(nums2[i]);
		}
        List<Integer> resultList = new LinkedList<>();
        for (Integer e : list1) {
			if (list2.remove(e)) {
				resultList.add(e);
			}
		}
        int size = resultList.size();
        if (size == 0) {
			return new int[0];
		}
        int[] result = new int[size];
        int count = 0;
        for (int i : resultList) {
			result[count] = i;
			count++;
		}
        return result;
    }
}
