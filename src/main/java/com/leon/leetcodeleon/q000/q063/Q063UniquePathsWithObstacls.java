package com.leon.leetcodeleon.q000.q063;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q063UniquePathsWithObstacls
{
	@Test
	public void test()
	{
		assert uniquePathsWithObstacles(new int[][] { { -1 } }) == 0;
		assert uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }) == 2;
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{

		if (obstacleGrid == null || obstacleGrid.length <= 0)
		{
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (obstacleGrid[i][j] == 1)
				{
					// 用-1标记为障碍物，非负数，表示 路径数
					obstacleGrid[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < n; i++)
		{
			if (obstacleGrid[0][i] < 0)
			{
				// 首行，存在障碍物时，后面的可到达路径，一定是0
				break;
			}
			obstacleGrid[0][i] = 1;
		}
		for (int j = 0; j < m; j++)
		{
			if (obstacleGrid[j][0] < 0)
			{
				// 首列，存在障碍物时，后面的可到达路径，一定是0
				break;
			}
			obstacleGrid[j][0] = 1;
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
				if (obstacleGrid[k][j] < 0)
				{
					continue;
				}
				int x = obstacleGrid[k - 1][j];
				int y = obstacleGrid[k][j - 1];
				obstacleGrid[k][j] = (x < 0 ? 0 : x) + (y < 0 ? 0 : y);
			}
			for (int k = 1; k < j && i > 0; k++)
			{
				if (obstacleGrid[i][k] < 0)
				{
					continue;
				}
				int x = obstacleGrid[i - 1][k];
				int y = obstacleGrid[i][k - 1];
				obstacleGrid[i][k] = (x < 0 ? 0 : x) + (y < 0 ? 0 : y);
			}
			if (obstacleGrid[i][j] >= 0)
			{
				int x = (i > 0 ? obstacleGrid[i - 1][j] : 0);
				int y = (j > 0 ? obstacleGrid[i][j - 1] : 0);
				obstacleGrid[i][j] = (x < 0 ? 0 : x) + (y < 0 ? 0 : y);
			}
			if (i < m)
				i++;
			if (j < n)
				j++;
		}
		ObjectUtils.print(obstacleGrid);
		int r = obstacleGrid[m - 1][n - 1];
		return r < 0 ? 0 : r;

	}
}
