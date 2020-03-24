package com.leon.leetcodeleon.mainshi.q1716;

import org.junit.Test;

public class Q1716Massage
{
	@Test
	public void test()
	{
		assert massage(new int[] { 1 }) == 1;
		assert massage(new int[] { 2, 1 }) == 2;
		assert massage(new int[] { 1, 2, 3, 1 }) == 4;
		assert massage(new int[] { 2, 7, 9, 3, 1 }) == 12;
		assert massage(new int[] { 2, 1, 4, 5, 3, 1, 1, 3 }) == 12;
	}

	public int massageV1(int[] nums)
	{
		if (nums.length <= 0)
		{
			return 0;
		}
		else if (nums.length <= 1)
		{
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++)
		{
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

	public int massage(int[] nums)
	{
		if (nums.length <= 0)
		{
			return 0;
		}
		else if (nums.length <= 1)
		{
			return nums[0];
		}
		int pp = nums[0];
		int p = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++)
		{
			int t = Math.max(pp + nums[i], p);
			pp = p;
			p = t;
		}
		return p;
	}
}
