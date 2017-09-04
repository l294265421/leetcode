package leetcode434;

/**
 * 
Count the number of segments in a string, where a segment is defined to be a contiguous 
sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5


 * @author liyuncong
 *
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s == null || s.trim().length() == 0) {
			return 0;
		} else {
			return s.split("\\s+").length;
		}
    }
}
