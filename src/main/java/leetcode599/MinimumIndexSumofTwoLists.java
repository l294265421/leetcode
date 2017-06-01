package leetcode599;

import java.util.LinkedList;
import java.util.List;

/**
 * 
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:

    The length of both lists will be in the range of [1, 1000].
    The length of strings in both lists will be in the range of [1, 30].
    The index is starting from 0 to the list length minus 1.
    No duplicates in both lists.

 * @author liyuncong
 *
 */
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
    	LinkedList<Integer> minIndexSums = new LinkedList<>();
    	LinkedList<String> minIndexCommonInterest = new LinkedList<>();
    	for(int i = 0; i < list1.length; i++) {
    		for(int j = 0; j < list2.length; j++) {
    			if (list1[i].equals(list2[j])) {
					if (minIndexSums.isEmpty()) {
						minIndexSums.add(i + j);
						minIndexCommonInterest.add(list1[i]);
					} else {
						if (minIndexSums.getFirst() == (i + j)) {
							minIndexSums.add(i + j);
							minIndexCommonInterest.add(list1[i]);
						} else if(minIndexSums.getFirst() > (i + j)) {
							minIndexSums.clear();
							minIndexCommonInterest.clear();
							minIndexSums.add(i + j);
							minIndexCommonInterest.add(list1[i]);
						}
					}
				}
    		}
    	}
    	
    	return minIndexCommonInterest.toArray(new String[0]);
    }
    
    public static void main(String[] args) {
		String[] list1 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = new String[] {"KFC", "Shogun", "Burger King"};
		MinimumIndexSumofTwoLists minimumIndexSumofTwoLists = new MinimumIndexSumofTwoLists();
		String[] result = minimumIndexSumofTwoLists.findRestaurant(list1, list2);
		for (String string : result) {
			System.out.println(string);
		}
	}
}
