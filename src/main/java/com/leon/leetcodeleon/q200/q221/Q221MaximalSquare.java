package com.leon.leetcodeleon.q200.q221;

import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q200.q221
 * @author zhangyunfei
 * @date 2020-05-08 00:22
 * @version V1.0
 */
public class Q221MaximalSquare
{
	@Test
	public void test()
	{
		assert maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }) == 4;
	}

	public int maximalSquare(char[][] matrix)
	{
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
		{
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int maxSide = 0;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (matrix[i][j] == '1')
				{
					if (i == 0 || j == 0)
					{
						dp[i][j] = 1;
					}
					else
					{
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					}
					maxSide = Math.max(maxSide, dp[i][j]);
				}
			}
		}
		return maxSide * maxSide;
	}
}
