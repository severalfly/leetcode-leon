package com.leon.leetcodeleon.q000.q073;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q073SetZeros
{
	@Test
	public void test()
	{
		setZeroes(new int[][] { { 1, 1, 1 }, { 0, 1, 2 } });
		// setZeroes(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } });
		// setZeroes(new int[][] { { 1, 0, 3 } });
		// setZeroes(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });
	}

	public void setZeroes(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
		{
			return;
		}
		// int k = 0;
		// System.out.println(k++);
		// ObjectUtils.print(matrix);
		int m = matrix.length;
		int n = matrix[0].length;
		boolean isCol = false;
		for (int i = 0; i < m; i++)
		{
			if (matrix[i][0] == 0)
			{
				isCol = true;
			}
			for (int j = 1; j < n; j++)
			{
				if (matrix[i][j] == 0)
				{
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		// System.out.println(k++);
		// ObjectUtils.print(matrix);
		for (int i = 1; i < m; i++)
		{
			if (matrix[i][0] == 0)
			{
				for (int j = 1; j < n; j++)
				{
					matrix[i][j] = 0;
				}
			}
		}
		// System.out.println(k++);
		// ObjectUtils.print(matrix);
		for (int j = 1; j < n; j++)
		{
			if (matrix[0][j] == 0)
			{
				for (int i = 1; i < m; i++)
				{
					matrix[i][j] = 0;
				}
			}
		}
		// System.out.println(k++);
		// ObjectUtils.print(matrix);
		if (matrix[0][0] == 0)
		{
			for (int j = 0; j < n; j++)
			{

				matrix[0][j] = 0;
			}
		}
		// System.out.println(k++);
		// ObjectUtils.print(matrix);
		if (isCol)
		{
			for (int i = 0; i < m; i++)
			{
				matrix[i][0] = 0;
			}
		}
		// System.out.println(k++);
		// ObjectUtils.print(matrix);


	}
}
