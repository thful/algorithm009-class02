package 数组;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * <p>
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 */
public class _0200岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(new _0200岛屿数量().numIslands(grid));
        System.out.println(new _0200岛屿数量().numIslands(grid2));
    }


    // 定义二维数组的长度
    private int n, m;

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        // 最终返回的岛屿个数
        int result = 0;
        n = grid.length;
        m = grid[0].length;
        // 二维数据进行扫描
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 发现陆地时把上 下 左 右都是1的陆地都变成大海
                if (grid[i][j] == '1') {
                    // 深度优先递归
                    DFSWrite(grid, i, j);
                    // 累加岛屿数量
                    result++;
                }
            }
        }
        return result;
    }

    private void DFSWrite(char[][] grid, int i, int j) {
        // 越界检查
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        // 如果上下左右的不是陆地(1)的时候不做处理
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        DFSWrite(grid, i + 1, j);
        DFSWrite(grid, i - 1, j);
        DFSWrite(grid, i, j + 1);
        DFSWrite(grid, i, j - 1);
    }
}
