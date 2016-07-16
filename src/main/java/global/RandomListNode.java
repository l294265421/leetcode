package global;

/**
 * Definition for singly-linked list with a random pointer.
 * @author liyuncong
 *
 */
public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		return "RandomListNode [label=" + label + ", next=" + next
				+ ", random=" + random + "]";
	}
	
}
