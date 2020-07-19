package 动态规划;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
public class _0300最长上升子序列 {
    // 状态：数组dp 其长度为数组长度 其中dp[i]表示下标i结尾的子数组最长上升子序列 包括自己
    // 边界：当子数组长度为1时 最长长度为1 因此dp[0]=1
    // 方程：对于1<=i<nums.length 遍历下标j从0到i-1 当num[j]<num[i]时dp[i]=Math.max(dp[i],dp[j]+1)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
