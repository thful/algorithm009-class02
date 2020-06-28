package 动态规划;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 */
public class _0064最小路径和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i != m - 1 && j == n - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i != m - 1 && j != n - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0];
    }
}
