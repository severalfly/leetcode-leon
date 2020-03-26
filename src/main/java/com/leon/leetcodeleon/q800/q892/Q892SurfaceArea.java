package com.leon.leetcodeleon.q800.q892;

import org.junit.Test;

public class Q892SurfaceArea
{
	@Test
	public void test()
	{
		assert surfaceArea(new int[][] { { 2 } }) == 10;
		assert surfaceArea(new int[][] { { 1, 2 }, { 3, 4 } }) == 34;
		assert surfaceArea(new int[][] { { 1, 0 }, { 0, 2 } }) == 16;
		assert surfaceArea(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }) == 32;
		assert surfaceArea(new int[][] { { 2, 2, 2 }, { 2, 1, 2 }, { 2, 2, 2 } }) == 46;
	}

	public int surfaceArea(int[][] grid)
	{
		if (grid == null || grid.length <= 0 || grid[0].length <= 0)
		{
			return 0;
		}
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;

		// 横向
		for (int i = 0; i < m; i++)
		{
			res += grid[i][0];
			for (int j = 0; j < n; j++)
			{
				if (j == n - 1)
				{
					res += grid[i][j];
					continue;
				}
				res += Math.abs(grid[i][j] - grid[i][j + 1]);
			}
		}

		// 纵向
		for (int j = 0; j < n; j++)
		{
			res += grid[0][j];
			for (int i = 0; i < m; i++)
			{
				if (i == m - 1)
				{
					res += grid[i][j];
					continue;
				}
				res += Math.abs(grid[i][j] - grid[i + 1][j]);
			}
		}

		// 顶天立地
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				res += grid[i][j] > 0 ? 2 : 0;
			}
		}
		return res;
	}
}
