package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 */
public class _0387字符串中的第一个唯一字符 {
    // 1.边界：如果为空返回-1
    // 2.逻辑：如果不为空 使用哈希表记录每个字符出现的次数 遍历字符串即可统计出来
    // 然后进行第二次遍历 遇到一个字符串出现为1时 返回下标 如果遍历结束还没有发现为1的 就返回-1
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] dp = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
