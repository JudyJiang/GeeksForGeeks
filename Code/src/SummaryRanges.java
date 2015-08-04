import java.util.LinkedList;
import java.util.List;


public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new LinkedList<String>();
		int start = 0;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] != 1) {
				if (start == i - 1) {
					sb.append(nums[start]);
				} else {
					sb.append(nums[start]);
					sb.append("->");
					sb.append(nums[i - 1]);
				}
				start = i;
				res.add(sb.toString());
				sb = new StringBuilder();
			}
		}

		if (start == nums.length - 1) {
			sb.append(nums[start]);
		} else {
			sb.append(nums[start]);
			sb.append("->");
			sb.append(nums[nums.length - 1]);
		}
		res.add(sb.toString());
		return res;
	}
}
