package com.leon.leetcodeleon.q000.q074;

import org.junit.Test;

public class Q074SearchMatrix
{
	@Test
	public void test()
	{
		assert !searchMatrix(new int[][] { { 1,1 } }, 2);
		assert searchMatrix(new int[][] { { 1 } }, 1);
		assert !searchMatrix(new int[][] { { 1 } }, 2);
		assert searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } }, 3);
		assert !searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } }, 13);
	}

	public boolean searchMatrix(int[][] matrix, int target)
	{
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
		{
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		// 第一步，搜索行
		int l = -1;
		int left = 0;
		int right = m - 1;
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (matrix[mid][0] > target)
			{
				right = mid - 1;
			}
			else if (matrix[mid][0] < target)
			{
				if (matrix[mid][n - 1] >= target)
				{
					left = mid;
					break;
				}

				left = mid + 1;
			}
			else
			{
				return true;
			}
		}

		if (left >= m)
		{
			return false;
		}
		l = left;

		// 第二步，搜索列
		left = 0;
		right = n - 1;

		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (matrix[l][mid] > target)
			{
				right = mid - 1;
			}
			else if (matrix[l][mid] < target)
			{
				left = mid + 1;
			}
			else
			{
				return true;
			}
		}

		return false;
	}
}
