package com.leon.leetcodeleon.q000.q072;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q072MinDistance extends BaseTest
{
	@Test
	public void test()
	{
		assert minDistance("horse", "ros") == 3;
		assert minDistance("intention", "execution") == 5;
	}

	public int minDistance(String word1, String word2)
	{
		int m = word1.length();
		int n = word2.length();
		if (m * n == 0)
		{
			return m + n;
		}
		int[][] d = new int[m + 1][n + 1];
		for (int i = 0; i < n + 1; i++)
		{
			d[0][i] = i;
		}
		for (int i = 0; i < m + 1; i++)
		{
			d[i][0] = i;
		}
		// ObjectUtils.print(d);
		// System.out.println();
		for (int i = 1; i < n + 1; i++)
		{
			for (int j = 1; j < m + 1; j++)
			{
				int left = d[j][i - 1] + 1;
				int down = d[j - 1][i] + 1;
				int leftDown = d[j - 1][i - 1];
				if (word1.charAt(j - 1) != word2.charAt(i - 1))
				{
					leftDown++;
				}
				d[j][i] = Math.min(left, Math.min(down, leftDown));
			}
		}
		// ObjectUtils.print(d);
		return d[m][n];

	}
}
