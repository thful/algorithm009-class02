package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 面试：字节跳动在半年内面试中考过
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
public class _0022括号生成 {
    public static void main(String[] args) {
        _0022括号生成 run = new _0022括号生成();
        System.out.println(run.generateParenthesis(3));
    }

    /**
     * 解题思路：
     * 1.每次都会有给定数据的两倍的括号
     */
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        _generate(0, 0, n, "");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        // 1.递归终止条件
        if (left == n && right == n) {
            System.out.println(s);
            result.add(s);
            return;
        }
        // 2.处理当前层逻辑

        // 3.下探到下一层
        if (left < n) //left随便加 只要不超过给定的数
            _generate(left + 1, right, n, s + "(");
        if (left > right) //right必须要加到left后面 且不能超过给定的数
            _generate(left, right + 1, n, s + ")");
        // 4.清理当前层(可选)
    }
}
