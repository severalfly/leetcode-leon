package com.leon.leetcodeleon.q300.q300;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q300LengthOfLIS extends BaseTest
{
	@Test
	public void test()
	{
		assert lengthOfLIS(new int[] { -2, -1 }) == 2;
		assert lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 4 }) == 3;
		assert lengthOfLIS(new int[] { 4, 10, 4, 3, 8, 9 }) == 3;
		assert lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }) == 4;
		assert lengthOfLIS(new int[] {}) == 0;
		assert lengthOfLIS(new int[] { 0 }) == 1;
	}

	public int lengthOfLIS(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = 1;
		for (int i = 0; i < nums.length; i++)
		{
			int m = 0;
			for (int j = 0; j < i; j++)
			{
				if (nums[i] > nums[j])
				{
					m = Math.max(m, dp[j]);
				}
			}
			dp[i] = m + 1;
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
