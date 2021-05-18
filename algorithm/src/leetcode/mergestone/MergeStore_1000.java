package leetcode.mergestone;

/**
 * 分析
 * 这道题是一道经典的区间dp问题，旨在通过动态规划去求一个区间的最优解，通过将大区间划分为很多个小区间，再由小区间的解来组合出大区间的解，这体现了分治的思想。
 * 
 * 区间 动态规划三部曲 定义状态：
 * 
 * 1.dp[i, j]为区间[i, j]的最优解
 * 
 * 2.定义状态转移方程：最常见的写法为：dp[i,j] =max/min{dp[i,j], dp[i, k] + dp[k+1, j] +cost}。
 * 选取[i, j]之间的一个分界点k，分别计算[i,k]和[k+1, j]的最优解，从而组合出[i, j]的最优解。
 * 
 * 3. 初始化：dp[i][i] =常数。区间长度为1时的最优解应当是已知的。
 * 
 * 
 * 定义dp[i][j][k]为合并第i堆到第j堆石头为k堆的成本，状态转移方程有关键两点：
 * 
 * dp[i][j][1] = dp[i][j][k] + sum(i, j)。不能直接求出合并为1堆的成本，得先合并成k堆。
 * 
 * dp[i][j][m] = min(dp[i][p][1] + dp[p + 1][j][m - 1])，i <= p < j，2 <= m <= k。
 * 
 * 这里m为堆数，不能直接用k是因为右部分的存在，要对右部分继续划分求解的话，子问题就必须有合并成m堆的情况。
 * 
 * 初始化dp[i][i][1] =0，答案就是dp[1][n][1]。
 * 
 * 对于无法实现的情况，定义dp[i][j][k] = max。
 * 
 * 
 * 作者：chenf99
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-merge-stones/solution/yi-dong-you-yi-dao-nan-yi-bu-bu-shuo-ming-si-lu-he/
 * 来源：力扣（LeetCode）
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class MergeStore_1000 {
	// 不用Integer.MAX_VALUE,因为Integer.MAX_VALUE + 正数 会溢出变为负数
	private int MAX_VALUE = 99999999;

	public int mergeStones(int[] stones, int k) {
		int n = stones.length;
		if ((n - 1) % (k - 1) != 0)
			return -1;
		int[][][] dp = new int[n + 1][n + 1][k + 1];
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; ++i)
			sum[i] = sum[i - 1] + stones[i - 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = i; j <= n; ++j) {
				for (int m = 2; m <= k; ++m)
					dp[i][j][m] = MAX_VALUE;
			}
			dp[i][i][1] = 0;
		}
		for (int len = 2; len <= n; ++len) { // 枚举区间长度
			for (int i = 1; i + len - 1 <= n; ++i) { // 枚举区间起点
				int j = i + len - 1;
				for (int m = 2; m <= k; ++m) { // 枚举堆数
					for (int p = i; p < j; p += k - 1) { // 枚举分界点
						dp[i][j][m] = Math.min(dp[i][j][m], dp[i][p][1] + dp[p + 1][j][m - 1]);
					}
				}
				dp[i][j][1] = dp[i][j][k] + sum[j] - sum[i - 1];
			}
		}
		return dp[1][n][1];
	}

}
