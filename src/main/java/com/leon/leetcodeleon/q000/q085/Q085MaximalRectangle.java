package com.leon.leetcodeleon.q000.q085;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q085MaximalRectangle extends BaseTest
{
	@Test
	public void test()
	{
		assert maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }) == 6;
	}

	public int maximalRectangle(char[][] matrix)
	{
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
		{
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] opt = new int[m][n];

		for (int j = 0; j < n; j++)
		{
			int d = 0;
			for (int i = 0; i < m; i++)
			{
				if (matrix[i][j] == '1')
				{
					d++;
				}
				else
				{
					d = 0;
				}
				opt[i][j] = d;
			}
		}
		ObjectUtils.print(opt);

		int max = 0;
		for (int i = 0; i < m; i++)
		{
			int last = 0;
			int min = opt[i][0];
			for (int j = 0; j < opt[i].length; j++)
			{
				int minHeight = opt[i][j];
				for (int k = j; k < opt[i].length; k++)
				{
					if (minHeight > opt[i][k])
					{
						minHeight = opt[i][k];
					}
					int area = minHeight * (k - j + 1);
					if (area > max)
					{
						max = area;
					}
				}
			}
		}
		System.out.println(max);
		return max;
	}
}
