package com.leon.leetcodeleon.q000.q053;

import org.junit.Test;

public class Q053MaxSubArray
{
	@Test
	public void test()
	{
		assert maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }) == 6;
		assert maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4, 2 }) == 7;
	}

	public int maxSubArray(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return 0;
		}
		int aMax = Integer.MIN_VALUE;
		int tMax = Integer.MIN_VALUE;
		for (int d : nums)
		{
			if (tMax < 0)
			{
				tMax = d;
			}
			else
			{
				tMax += d;
			}
			if (tMax > aMax)
			{
				aMax = tMax;
			}
		}
		return aMax;
	}
}
