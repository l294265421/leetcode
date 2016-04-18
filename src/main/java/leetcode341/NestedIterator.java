package leetcode341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
	// 这其实是一个森林，森林里有nestedList.size()这么多棵树
	private List<NestedInteger> nestedList;
	// 从最上层到最下层路径上当前元素在所在层的索引位置，它唯一确定一个元素
	private List<Integer> positions = new LinkedList<>();
	
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        // 最左边的元素位置
        boolean findNext = false;
        NestedInteger cursor = nestedList.get(0);
        while (!findNext) {
        	if (cursor.isInteger()) {
				positions.add(0);
				findNext = true;
			} else {
				cursor = cursor.getList().get(0);
			}
		}
    }

    @Override
    public Integer next() {
        int size = positions.size();
        LinkedList<List<NestedInteger>> stack = new LinkedList<>();
        // 找到positions定为的的元素
        List<NestedInteger> temp = this.nestedList;
        stack.push(temp);
        int i = 0;
        for (; i < size - 1; i++) {
			temp = temp.get(positions.get(i)).getList();
			stack.push(temp);
		}
        Integer result = temp.get(positions.get(i)).getInteger();
        // 寻找下一个positions
        // 在已有的List<NestedInteger>中寻找离下一个元素的最近的（寻找下一个元素在已有List<NestedInteger>中最近的祖先）
        boolean findNext = false;
        List<NestedInteger> targetList = stack.poll();
        while (!findNext && stack.size() != 0) {
			if (targetList.size() != positions.get(positions.size() - 1)) {
				
			}
		}
        
        return result;
    }

    @Override
    public boolean hasNext() {
        return positions.size() != 0;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
