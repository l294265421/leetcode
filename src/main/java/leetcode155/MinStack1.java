package leetcode155;

import java.util.ArrayList;

class MinStack1 {
	private ArrayList<Integer> elements = new ArrayList<Integer>();

	public void push(int x) {
		elements.add(x);
	}

	public void pop() {
		int size = elements.size();
		if (size == 0) {
			throw new IndexOutOfBoundsException("stack was empty");
		} else {
			elements.remove(size - 1);
		}
	}

	public int top() {
		return elements.get(elements.size() - 1);
	}

	public int getMin() {
		if (elements.size() == 0) {
			throw new IndexOutOfBoundsException("stack was empty");
		}
		int size = elements.size();
		int min = elements.get(0);
		for (int i = 1; i < size; i++) {
			int temp = elements.get(i);
			if (temp < min) {
				min = temp;
			}
		}
		return min;
	}
}
