package 数组;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class _0033搜索旋转排序数组 {
    /**
     * 1.暴力：还原O(n)【题目要求必须要O(logn)所以可以先用二分还原排序】 -->再用常规二分查找
     * 2.正解：硬套二分查找
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // [0,mid]有序 向后匹配
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                // 向后匹配
                left = mid + 1;
            }
            // [0,mid]被旋转了 向后匹配
            else if (target > nums[mid] && target < nums[0]) {
                // 向后匹配
                left = mid + 1;
            } else {
                // 其它情况 向前匹配
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
}
