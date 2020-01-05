package com.leon.leetcodeleon.q000.q064;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q064MinPathSum
{
	@Test
	public void test()
	{
		// assert minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }) == 7;
		assert minPathSum(new int[][] { { 1, 4, 8, 6, 2, 2, 1, 7 }, { 4, 7, 3, 1, 4, 5, 5, 1 }, { 8, 8, 2, 1, 1, 8, 0, 1 }, { 8, 9, 2, 9, 8, 0, 8, 9 }, { 5, 7, 5, 7, 1, 8, 5, 5 }, { 7, 0, 9, 4, 5, 6, 5, 6 }, { 4, 9, 9, 7, 9, 1, 9, 0 } }) == 47;
	}

	public int minPathSum(int[][] grid)
	{
		if (grid == null || grid.length <= 0 || grid[0].length <= 0)
		{
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] rs = new int[m][n];
		rs[0][0] = grid[0][0];

		for (int i = 1; i < n; i++)
		{
			rs[0][i] = grid[0][i] + grid[0][i - 1];
			grid[0][i] = rs[0][i];
		}
		for (int j = 1; j < m; j++)
		{
			rs[j][0] += grid[j][0] + grid[j - 1][0];
			grid[j][0] = rs[j][0];
		}
		int i = 1;
		int j = 1;
		while (i < m || j < n)
		{
			if (j >= n)
			{
				j = n - 1;
			}
			if (i >= m)
			{
				i = m - 1;
			}
			for (int k = 1; k < i && j > 0; k++)
			{
				rs[k][j] = grid[k][j] + Math.min(rs[k - 1][j], rs[k][j - 1]);
			}
			for (int k = 1; k < j && i > 0; k++)
			{
				rs[i][k] = grid[i][k] + Math.min(rs[i - 1][k], rs[i][k - 1]);
			}
			rs[i][j] = grid[i][j] + Math.min((i > 0 ? rs[i - 1][j] : 0), (j > 0 ? rs[i][j - 1] : 0));

			if (i < m)
				i++;
			if (j < n)
				j++;
		}
		// ObjectUtils.print(rs);
		return rs[m - 1][n - 1];
	}
}
