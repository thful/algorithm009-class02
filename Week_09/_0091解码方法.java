package 动态规划;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/decode-ways
 */
public class _0091解码方法 {
    /**
     * 1.状态：假设字符串s 的长度为n 创建数组长度为n+1 其中dp[i]表示从下标i开始的后缀解码方法 dp[n]对应空字符串的解码方法数
     * 2.边界：空字符串对应1种解法 dp[n]=1 长度为1如果该字符为0不能解码 否则有1种 dp[n-1]=s.chatAt(n-1)=='0'?0:1
     * 3.方程：i从n-2到0 如果s.chatAt(i)=='0' 则dp[i]=0 否则判断下标在i和i+1的字符组成的两位数nums的值 如果num<=26则dp[i]=dp[i+1]+dp[i+2] 否则dp[i]=dp[i+1]
     * 4.结果：dp[0]
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            int digit0 = s.charAt(i) - '0', digit1 = s.charAt(i + 1) - '0';
            if (digit0 == 0) {
                dp[i] = 0;
            } else {
                int num = digit0 * 10 + digit1;
                dp[i] = num <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        return dp[0];
    }
}
