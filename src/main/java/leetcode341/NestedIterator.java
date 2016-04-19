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
	// 从上到下的list，每个list的元素个数都大于0
	LinkedList<List<NestedInteger>> ancestorsStack = new LinkedList<>();
	// 与ancestorsStack对应，记录每个List<NestedInteger>在父list中的索引位置，
	// 根list在父list中的位置设为-1
	LinkedList<Integer> positions = new LinkedList<Integer>();
	// 下一个元素在父list中的索引位置
	private int integerIndex = 0;
	
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        
        if (nestedList.size() == 0) {
			return;
		}
        ancestorsStack.push(nestedList);
        positions.push(-1);
        // 最左边的元素位置
        boolean findNext = false;
        NestedInteger cursor = nestedList.get(0);
        // 当前元素在父list中的索引位置
        int thisIndex = 0;
        while (!findNext) {
        	if (cursor.isInteger()) {
        		integerIndex = thisIndex;
				findNext = true;
			} else {
				if (cursor.getList().size() != 0) {
					// 往下走
					ancestorsStack.push(cursor.getList());
					positions.push(thisIndex);
					thisIndex = 0;
					cursor = cursor.getList().get(thisIndex);
				} else {
					if (thisIndex < ancestorsStack.peek().size() - 1) {
						// 往右走
						thisIndex++;
						cursor = ancestorsStack.peek().get(thisIndex);
					} else {
						// 往上走
						ancestorsStack.pop();
						thisIndex = positions.pop();
					  	while (!ancestorsStack.isEmpty()) {
							List<NestedInteger> temp = ancestorsStack.peek();
							int size = temp.size();
							if (thisIndex != size - 1) {
								thisIndex++;
								cursor = ancestorsStack.peek().get(thisIndex);
								break;
							} else {
								ancestorsStack.pop();
								thisIndex = positions.pop();
							}
							
						}
					  	if (ancestorsStack.isEmpty()) {
							break;
						}
					}
				}
			}
		}
    }

    @Override
    public Integer next() {
    	Integer result = ancestorsStack.peek().get(integerIndex).
    			getInteger();
    	
    	if (integerIndex != ancestorsStack.peek().size() - 1 && 
    			ancestorsStack.peek().get(integerIndex + 1).isInteger()) {
			integerIndex++;
			return result;
		}
    	
    	int indexTemp = integerIndex;
    	// 往上
    	if (integerIndex == ancestorsStack.peek().size() - 1) {
    		// 寻找ancestorsStack中下一个元素的最近祖先
        	ancestorsStack.pop();
        	indexTemp = positions.pop();
        	
        	while (!ancestorsStack.isEmpty()) {
    			List<NestedInteger> temp = ancestorsStack.peek();
    			int size = temp.size();
    			if (indexTemp != size - 1) {
    				break;
    			} else {
    				ancestorsStack.pop();
    				indexTemp = positions.pop();
    			}
    			
    		}
		}
    	
    	if (ancestorsStack.isEmpty()) {
			return result;
		}
    	
        boolean findNext = false;
        // 以ancestorsStack.peek().get(indexTemp + 1)作为起点寻找第一个Integer
        NestedInteger cursor = ancestorsStack.peek().get(indexTemp + 1);
        int thisIndex = indexTemp + 1;
        while (!findNext) {
        	if (cursor.isInteger()) {
        		integerIndex = thisIndex;
				findNext = true;
			} else {
				if (cursor.getList().size() != 0) {
					// 往下走
					ancestorsStack.push(cursor.getList());
					positions.push(thisIndex);
					thisIndex = 0;
					cursor = cursor.getList().get(thisIndex);
				} else {
					if (thisIndex < ancestorsStack.peek().size() - 1) {
						// 往右走
						thisIndex++;
						cursor = ancestorsStack.peek().get(thisIndex);
					} else {
						// 往上走
						ancestorsStack.pop();
						thisIndex = positions.pop();
					  	while (!ancestorsStack.isEmpty()) {
							List<NestedInteger> temp = ancestorsStack.peek();
							int size = temp.size();
							if (thisIndex != size - 1) {
								thisIndex++;
								cursor = ancestorsStack.peek().get(thisIndex);
								break;
							} else {
								ancestorsStack.pop();
								thisIndex = positions.pop();
							}
							
						}
					  	if (ancestorsStack.isEmpty()) {
							break;
						}
					}
				}
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
