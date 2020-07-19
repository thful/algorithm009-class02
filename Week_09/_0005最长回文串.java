package 动态规划;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class _0005最长回文串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;
        int len = s.length();
        int count = 0;
        String result = "";
        boolean[][] dp = new boolean[len][len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (i - j >= count && dp[i][j]) {
                    count = i - j;
                    result = s.substring(j, i + 1);
                }
            }
        }
        return result;
    }

}
