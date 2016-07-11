package leetcode42;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * @author liyuncong
 *
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
			return 0;
		}
        return strategy1(height);
    }
    
    /**
     * 1.寻找波峰
     * 2.何为波峰？比左右都大的值
     * 3.怎么确定容积？以低的波峰为标准，向另一边移动，比波峰少多少，容积就加多少
     * @return
     */
    private int strategy1(int[] height) {
    	int result = 0;
    	
    	// 寻找波峰
    	List<Integer> peaks = findPeaks(height);
    	
    	// 计算累积的雨水
    	for(int i = 0; i < peaks.size() - 1; i ++) {
    		result += trappingRainWater(height, peaks.get(i), peaks.get(i + 1));
    	}
    	return result;
    }
    
    /**
     * 寻找波峰
     * @param height
     * @return
     */
    private List<Integer> findPeaks(int[] height) {
    	// 何为波峰？比左右都大的值
    	List<Integer> peaks = findObviousPeak(height);
    	
    	// 合并之后的波峰
    	List<Integer> realPeaks = merge(peaks, height);
    	
    	return realPeaks;
	}
    
    /**
     * 寻找波峰
     * @param height 
     * @return 何为波峰？比左右都大的值
     */
    private List<Integer> findObviousPeak(int[] height) {
    	List<Integer> peaks = new LinkedList<>();
    	int realStartIndex = 0;
    	int len = height.length;
    	while (realStartIndex < len - 1 && height[realStartIndex] == height[realStartIndex + 1]) {
			realStartIndex++;
		}
    	if (realStartIndex < len - 1 && height[realStartIndex] > height[realStartIndex + 1]) {
			peaks.add(realStartIndex);
		}
    	int realEndIndex = len - 1;
    	while (realEndIndex > 0 && height[realEndIndex] == height[realEndIndex - 1]) {
			realEndIndex--;
		}
    	for(int i = realStartIndex + 1; i < realEndIndex; i++) {
    		int nextIndex = i + 1;
    		while (nextIndex <= realEndIndex && height[nextIndex] == height[nextIndex - 1]) {
				nextIndex++;
			}
    		if (height[i] != height[i - 1] && height[i] > height[i - 1] && height[i] > height[nextIndex]) {
				peaks.add(i);
			}
    	}
    	if (realEndIndex > 0 && height[realEndIndex] > height[realEndIndex - 1]) {
			peaks.add(realEndIndex);
		}
    	
    	// 合并之后的波峰
    	return peaks;
	}
    
    /**
     * 任意两个波峰之间的波峰，如果比这两个波峰都矮，就去掉
     * @param peaks 比左右都大的值
     * @return 合并之后的peaks
     */
    private List<Integer> merge(List<Integer> peaks, int[] height) {
    	int size = peaks.size();
		boolean[] deleteFlags = new boolean[size];
		
		for(int i = 1; i < size - 1; i++) {
			int ivalue = height[peaks.get(i)];
			boolean leftFlag = false;
			for(int j = i - 1; j >= 0; j--) {
				if (height[peaks.get(j)] > ivalue) {
					leftFlag = true;
					break;
				}
			}
			if (!leftFlag) {
				continue;
			}
			boolean rightFlag = false;
			for(int j = i + 1; j <= size - 1; j++) {
				if (height[peaks.get(j)] > ivalue) {
					rightFlag = true;
					break;
				}
			}
			if (rightFlag) {
				deleteFlags[i] = true;
			}
//			O（n^3）被优化了
//			for(int j = size - 1; j > i; j--) {
//				int jvalue = height[peaks.get(j)];
//				for(int k = i + 1; k < j; k++) {
//					if (!deleteFlags[k] && height[peaks.get(k)] < ivalue && height[peaks.get(k)] < jvalue) {
//						deleteFlags[k] = true;
//					}
//				}
//			}
		}
		
		List<Integer> realPeaks = new LinkedList<>();
		for(int i = 0; i < size; i++) {
			if (!deleteFlags[i]) {
				realPeaks.add(peaks.get(i));
			}
		}
		return realPeaks;
	}
    
    /**
     * 
     * @param height
     * @param firstPeakIndex 第一个波峰
     * @param secondPeakIndex 和第一个波峰相邻的第二个波峰
     * @return 两波峰之间累积的雨水
     */
    private int trappingRainWater(int[] height, int firstPeakIndex, int secondPeakIndex) {
    	int result = 0;
		int firstPeak = height[firstPeakIndex];
		int secondPeak = height[secondPeakIndex];
		if (firstPeak < secondPeak) {
			for(int i = firstPeakIndex + 1; i < secondPeakIndex; i++) {
				if (firstPeak > height[i]) {
					result = result + (firstPeak - height[i]);
				}
			}
		} else {
			for(int i = secondPeakIndex - 1; i > firstPeakIndex; i--) {
				if (secondPeak > height[i]) {
					result = result + (secondPeak - height[i]);
				}
			}
		}
		return result;
	}
    
    public static void main(String[] args) {
		TrappingRainWater trappingRainWater = new TrappingRainWater();
		int[] height = new int[] {9,6,8,8,5,6,3};
		System.out.println(trappingRainWater.trap(height));
	}
}
