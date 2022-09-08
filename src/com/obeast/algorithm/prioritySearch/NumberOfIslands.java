package com.obeast.algorithm.prioritySearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wxl
 * Date 2022/8/25 11:46
 * @version 1.0
 * Description: 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        String[][] grid = new String[][]{
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };
        System.out.println(numIslands2(grid));

    }

    /**
     * Description: 深度搜索
     * @author wxl
     * Date: 2022/8/25 14:40
     * @param grid grid
     * @param r row
     * @param c column
     */
    public static void dfs(String[][] grid, int r, int c) {
        int row = grid.length;
        int column = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= column || "0".equals(grid[r][c])){
            return;
        }

        grid[r][c] = "0";

        //上
        dfs(grid, r + 1, c);
        //下
        dfs(grid, r - 1, c);
        //左
        dfs(grid, r, c - 1);
        //右
        dfs(grid, r, c + 1);

    }

    /**
     * Description: 判断是否为陆地
     * @author wxl
     * Date: 2022/8/25 14:39
     * @param grid grid
     * @return int
     */
    public static int numIslands(String[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int lands = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if ("1".equals(grid[i][j])) {
                    ++lands;
                    dfs(grid, i, j);
                }
            }
        }
        return lands;

    }

    /**
     * Description: 广度优先
     * @author wxl
     * Date: 2022/8/25 16:54
     * @param grid grid
     * @return int
     */
    public static int numIslands2(String[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == "1") {
                    ++num_islands;
                    grid[r][c] = "0";
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == "1") {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = "0";
                        }
                        if (row + 1 < nr && grid[row+1][col] == "1") {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = "0";
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == "1") {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = "0";
                        }
                        if (col + 1 < nc && grid[row][col+1] == "1") {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = "0";
                        }
                    }
                }
            }
        }
        return num_islands;
    }

}
