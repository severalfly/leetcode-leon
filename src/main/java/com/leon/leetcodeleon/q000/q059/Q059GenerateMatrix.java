package com.leon.leetcodeleon.q000.q059;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q059GenerateMatrix
{
	@Test
	public void test()
	{
		ObjectUtils.print(generateMatrix(5));
	}

	public int[][] generateMatrix(int n)
	{
		if (n <= 0)
		{
			return new int[][] {};
		}
		if (n == 1)
		{
			return new int[][] { { 1 } };
		}
		int[][] r = new int[n][n];
		int k = 0;
		int cnt = 1;
		while (k <= n / 2)
		{
			// 1. 横向增
			for (int i = k; i < n - k; i++)
			{
				r[k][i] = cnt++;
			}

			// 2. 竖向增
			for (int j = k + 1; j < n - k; j++)
			{
				r[j][n - k - 1] = cnt++;
			}

			// 3. 横向减

			for (int i = n - k - 2; i >= k; i--)
			{
				r[n - k - 1][i] = cnt++;
			}

			// 4. 竖向减
			for (int j = n - k - 2; j > k; j--)
			{
				r[j][k] = cnt++;
			}
			k++;
		}
		return r;
	}
}
