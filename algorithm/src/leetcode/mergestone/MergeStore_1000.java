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

}
