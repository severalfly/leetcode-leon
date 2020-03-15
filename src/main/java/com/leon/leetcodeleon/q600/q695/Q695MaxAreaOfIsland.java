package com.leon.leetcodeleon.q600.q695;

import org.junit.Test;

public class Q695MaxAreaOfIsland
{
	int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	@Test
	public void test()
	{
		assert maxAreaOfIsland(new int[][] { { 1, 1, 1 }, { 1, 0, 0 } }) == 4;
		assert maxAreaOfIsland(new int[][] { { 0, 1, 1 }, { 0, 0, 1 } }) == 3;
		assert maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }) == 6;
	}

	public int maxAreaOfIsland(int[][] grid)
	{
		if (grid == null || grid.length <= 0 || grid[0].length <= 0)
		{
			return 0;
		}
		// int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int max = 0;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] == 1)
				{
					grid[i][j] = 0;

					int helper = helper(grid, i, j) + 1;
					if (helper > max)
					{
						max = helper;
					}
				}
			}
		}
		return max;
	}

	private int helper(int[][] grid, int i, int j)
	{
		int c = grid.length; // 行数
		int r = grid[0].length; // 列数
		int max = 0;
		// int m = 0;

		// 此处，可开始
		for (int[] dir : direction)
		{
			int ni = dir[0] + i;
			int nj = dir[1] + j;
			if (limit(ni, nj, c, r) && grid[ni][nj] == 1)
			{
				max++;
				// 防止重复检测同一个点
				grid[ni][nj] = 0;
				// if (m > max)
				// {
				// 	max = m;
				// }
				max += helper(grid, ni, nj);
			}

		}
		return max;
	}

	private boolean limit(int i, int j, int m, int n)
	{
		if (i >= 0 && i < m && j >= 0 && j < n)
		{
			return true;
		}
		return false;
	}
}
