package leetcode335;

import java.util.LinkedList;
import java.util.List;

/**
 * 方案1：根据所给数组得到所有线段，计算两两之间是否相交 
 * 方案2：根据数组中每个元素，得到一个线段，然后立即计算该线段与之前得到的线段是否有交点，如果有，
 * 就立刻返回，没有，就继续 
 * 
 * @author yuncong
 *
 */
public class LeetCode335 {

	public boolean isSelfCrossing(int[] x) {
		int len = x.length;
		if (len < 4) {
			return false;
		}
		List<LineSegment> comparedLineSegments = new LinkedList<LeetCode335.
				LineSegment>();
		Point lastPoint = new Point(0, 0);
		
		return false;
	}
	
	private static class Point {
		private int x;
		private int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}

	private static class LineSegment {
		private Point start;
		private Point end;
		private State state;
		
		public LineSegment(Point start, Point end, State state) {
			super();
			this.start = start;
			this.end = end;
			this.state = state;
		}

		public Point getStart() {
			return start;
		}

		public Point getEnd() {
			return end;
		}

		public State getState() {
			return state;
		}

		
		
		@Override
		public String toString() {
			return "LineSegment [start=" + start + ", end=" + end + ", state="
					+ state + "]";
		}

		public boolean crossTo(LineSegment other) {
			if (this.state != other.getState()) {
				int x1;
				int x2;
				int x3;
				int y1;
				int y2;
				int y3;
				if (this.state == State.HORIZONTAL) {
					x1 = this.start.getX();
					x2 = this.end.getY();
					x3 = other.getStart().getX();
					y1 = this.start.getY();
					y2 = other.getStart().getY();
					y3 = other.getEnd().getY();
				} else {
					x1 = other.getStart().getX();
					x2 = other.getEnd().getX();
					x3 = this.getStart().getX();
					y1 =other.getStart().getY();
					y2 = this.getStart().getY();
					y3 = this.getEnd().getY();
				}
				if (x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2) 
						&& y1 >= Math.min(y2, y3) && y1 <= Math.max(y2, y3)) {
					return true;
				}
			}
			return false;
		}
		
		private enum State {
			VERTICAL,
			HORIZONTAL
			
		}
		
		public enum Direction {
			NORTH,
			WEST,
			SOUTH,
			EAST
		}
		
		public static LineSegment makeLineSegment(Point start, int length, 
				Direction direction) {
			Point end;
			State state;
			switch (direction) {
			case NORTH:
				end = new Point(start.getX(), start.getY() + length);
				state = State.VERTICAL;
				break;

			case WEST:
				end = new Point(start.getX() - length, start.getY());
				state = State.HORIZONTAL;
			case SOUTH:
				end = new Point(start.getX(), start.getY() - length);
				state = State.VERTICAL;
			default:
				end = new Point(start.getX() +length, start.getY());
				state = State.HORIZONTAL;
				break;
			}
			return new LineSegment(start, end, state);
		}
	}
	public static void main(String[] args) {

	}

}
