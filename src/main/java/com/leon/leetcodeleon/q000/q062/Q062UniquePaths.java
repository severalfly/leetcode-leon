package com.leon.leetcodeleon.q000.q062;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q062UniquePaths
{
	@Test
	public void test()
	{
		assert uniquePaths(10, 1) == 1;
		assert uniquePaths(1, 10) == 1;
		assert uniquePaths(1, 2) == 1;
		assert uniquePaths(7, 3) == 28;
		assert uniquePaths(3, 7) == 28;
		assert uniquePaths(3, 2) == 3;
		assert uniquePaths(4, 4) == 20;
	}

	public int uniquePaths(int m, int n)
	{
		if (m <= 0 || n <= 0)
		{
			return 0;
		}
		int[][] rs = new int[m][n];
		for (int i = 0; i < n; i++)
		{
			rs[0][i] = 1;
		}
		for (int j = 0; j < m; j++)
		{
			rs[j][0] = 1;
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
				rs[k][j] = rs[k - 1][j] + rs[k][j - 1];
			}
			for (int k = 1; k < j && i > 0; k++)
			{
				rs[i][k] = rs[i - 1][k] + rs[i][k - 1];
			}
			rs[i][j] = (i > 0 ? rs[i - 1][j] : 0) + (j > 0 ? rs[i][j - 1] : 0);

			if (i < m)
				i++;
			if (j < n)
				j++;
		}
		ObjectUtils.print(rs);
		return rs[m - 1][n - 1];
	}
}
