package leetcode155;

class MinStack {
	private int min = 0;
	private final int LENGTH = 100;
	private int[] elements = new int[LENGTH];
	private int topIndex = -1;

	public void push(int x) {
		if (topIndex == LENGTH - 1) {
			throw new IndexOutOfBoundsException("stack was full");
		} else {
			elements[++topIndex] = x;
			if (x < min || topIndex == 0) {
				min = x;
			}
		}
	}

	public void pop() {
		if (topIndex == -1) {
			throw new IndexOutOfBoundsException("stack was empty");
		} else {
			topIndex--;
		}
	}

	public int top() {
		if (topIndex == -1) {
			throw new IndexOutOfBoundsException("stack was empty");
		}
		return elements[topIndex];
	}

	public int getMin() {
		return this.min;
	}
}
