package com.leon.leetcodeleon.q900.q945;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q945MinIncrementForUnique extends BaseTest
{
	@Test
	public void test()
	{
		// assert minIncrementForUnique(new int[] { 1 }) == 0;
		// assert minIncrementForUnique(new int[] { 1, 2 }) == 0;
		// assert minIncrementForUnique(new int[] { 1, 2, 2 }) == 1;
		// assert minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }) == 6;
		assert minIncrementForUnique(new int[] { 1, 2, 2, 3, 3, 4 }) == 6;
		assert minIncrementForUnique(new int[] { 1, 2, 2, 3, 3, 4, 4 }) == 9;
	}

	public int minIncrementForUnique(int[] A)
	{
		if (A.length == 0)
		{
			return 0;
		}
		int[] tmp = new int[5];
		for (int i = 0; i < A.length; i++)
		{
			tmp[A[i]]++;
		}
		int count = 0;
		for (int i = 0; i < tmp.length - 1; i++)
		{
			if (tmp[i] > 1)
			{
				int t = tmp[i] - 1;
				count += t;
				tmp[i + 1] += t;
				tmp[i] -= t; // 这一步可以去除
			}
		}
		System.out.println(tmp[tmp.length - 1]);
		int t = tmp[tmp.length - 1] - 1;

		count += t * (t + 1) / 2;
		return count;
	}
}
