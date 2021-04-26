package leetcode.twosum;

public class TwoSum_1 {
	// 时间复杂度为o(n2)
	public int[] twoSum(int[] nums, int target) {
		int[] arr = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			int num = target - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (num == nums[j]) {
					arr[0] = i;
					arr[1] = j;
					break;
				}
			}
		}
		return arr;
	}
	// 可以用哈希表的想法做用空间换时间，时间复杂度为o（1）
}
