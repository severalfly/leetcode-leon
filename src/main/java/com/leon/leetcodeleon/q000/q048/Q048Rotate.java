package com.leon.leetcodeleon.q000.q048;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Q048Rotate
{
	@Test
	public void test()
	{
		rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		rotate(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } });
	}

	public void rotate(int[][] matrix)
	{
		if (matrix == null || matrix.length <= 0)
		{
			return;
		}
		int len = matrix.length;

		for (int k = 0; k < len / 2; k++)
		{
			for (int j = k; j < len - 1 && j < d(k, len); j++)
			{
				int m = k;
				int n = j;
				int tmp = matrix[m][n];

				matrix[m][n] = matrix[d(n, len)][m];
				matrix[d(n, len)][m] = matrix[d(m, len)][d(n, len)];
				matrix[d(m, len)][d(n, len)] = matrix[d(d(n, len), len)][d(m, len)];
				matrix[d(d(n, len), len)][d(m, len)] = tmp;

			}
		}
	}

	private int d(int n, int sum)
	{
		return sum - 1 - n;
	}
}
