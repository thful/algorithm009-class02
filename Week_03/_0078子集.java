package 递归;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets
 */
public class _0078子集 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new LinkedList<>();
        subsets(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private void subsets(int[] nums, int current, LinkedList<Integer> track, List<List<Integer>> result) {
        // 已遍历完所有元素
        if (current == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        // 不选择此数
        subsets(nums, current + 1, track, result);
        // 选择此数
        track.add(nums[current]);
        subsets(nums, current + 1, track, result);
        // 撤销选择当前元素 回溯
        track.removeLast();
    }
}
