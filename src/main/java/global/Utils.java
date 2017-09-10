package global;

public class Utils {
	public static String arrayAdapter(String leetcodeArray) {
		String result = leetcodeArray.replaceAll("\\[", "{");
		result = result.replaceAll("\\]", "}");
		return result;
	}
}
