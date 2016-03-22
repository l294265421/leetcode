package leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode492 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return ans;
		}
		Arrays.sort(strs);
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] sCharArr = s.toCharArray();
			Arrays.sort(sCharArr);
			String key = new String(sCharArr);
			List<String> list = map.get(key);
			if (list == null) {
				List<String> temp = new ArrayList<>();
				temp.add(s);
				map.put(key, temp);
			} else {
				list.add(s);
			}
		}
		ans.addAll(map.values());
		return ans;
	}
}
