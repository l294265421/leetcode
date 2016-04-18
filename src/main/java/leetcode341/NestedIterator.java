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
	LinkedList<List<NestedInteger>> ancestorsStack = new LinkedList<>();
	// 与ancestorsStack对应，记录每个List<NestedInteger>在父list中的索引位置
	LinkedList<Integer> positions = new LinkedList<Integer>();
	// 下一个元素在父list中的索引位置
	private int integerIndex = 0;
	
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        
        if (nestedList.size() == 0) {
			return;
		}
        
        ancestorsStack.add(nestedList);
        positions.add(-1);
        // 最左边的元素位置
        boolean findNext = false;
        NestedInteger cursor = nestedList.get(0);
        while (!findNext) {
        	if (cursor.isInteger()) {
				findNext = true;
			} else {
				ancestorsStack.add(cursor.getList());
				positions.add(0);
				cursor = cursor.getList().get(0);
			}
		}
    }

    @Override
    public Integer next() {
    	Integer result = ancestorsStack.peek().get(integerIndex).
    			getInteger();
    	
    	if (integerIndex != ancestorsStack.peek().size() - 1) {
			integerIndex++;
			return result;
		}
    	
    	// 寻找ancestorsStack中下一个元素的最近祖先
    	ancestorsStack.poll();
    	int indexTemp = positions.poll();
    	
    	while (!ancestorsStack.isEmpty()) {
			List<NestedInteger> temp = ancestorsStack.peek();
			int size = temp.size();
			if (indexTemp != size - 1) {
				break;
			} else {
				ancestorsStack.poll();
				indexTemp = positions.poll();
			}
			
		}
    	
    	if (ancestorsStack.isEmpty()) {
			return result;
		}
    	
    	boolean findNext = false;
    	int targetIndex = indexTemp + 1;
        NestedInteger cursor = ancestorsStack.peek().get(targetIndex);
        while (!findNext) {
        	if (cursor.isInteger()) {
        		integerIndex = 0;
				findNext = true;
			} else {
				ancestorsStack.add(cursor.getList());
				positions.add(0);
				cursor = cursor.getList().get(0);
			}
		}
        
        return result;
    }

    @Override
    public boolean hasNext() {
        return !ancestorsStack.isEmpty();
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
