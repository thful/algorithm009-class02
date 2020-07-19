package 动态规划;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * 提示：
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 */
public class _0541反转字符串II {
    // 将字符串分成组 每组是长度2k的子串 对于每组的前k的字符进行反转操作
    public String reverseStr(String s, int k) {
        char[] arrys = s.toCharArray();
        for (int i = 0; i < arrys.length; i = i + 2 * k) {
            int start = i;
            int end = Math.min(start + k - 1, arrys.length - 1);
            // 进行反转的范围
            while (start < end) {
                char temp = arrys[start];
                arrys[start++] = arrys[end];
                arrys[end--] = temp;
            }
        }
        return new String(arrys);
    }
}
