package 数组;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 链接：https://leetcode-cn.com/problems/jump-game
 */
public class _0055跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        // 从后向前查找
        int pos = nums.length - 1;
        for (int i = pos; i >= 0; i--) {
            // 代表此下标的上一个可以跳到这里
            // 就把上一个变为下一次下标
            if (i + nums[i] >= pos) pos = i;
        }
        // 如果循环完毕 下标等于0就代表整个数组已经到达首端 代表可以从头跳到尾
        return pos == 0;
    }
}
