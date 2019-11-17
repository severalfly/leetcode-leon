package com.leon.leetcodeleon.q000.q041;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q041FirstMissingPostive extends BaseTest
{

	@Test
	public void test()
	{
		assert firstMissingPositive(new int[] { 1, 2, 0 }) == 3;
		assert firstMissingPositive(new int[] { 3, 4, -1, 1 }) == 2;
		assert firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }) == 1;
	}

	public int firstMissingPositive(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return 1;
		}
		// 1 出现的次数
		int onecnt = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++)
		{
			if (nums[i] == 1)
			{
				onecnt++;
			}
			if (nums[i] <= 0 || nums[i] > len)
			{
				nums[i] = 1;
			}
		}
		if (onecnt == 0)
		{
			return 1;
		}
		if (len == 1)
		{
			// 有1，并且长度为1时，肯定是返回2了
			return 2;
		}

		for (int i = 0; i < len; i++)
		{
			int k = nums[i] % len;
			if (k < 0)
			{
				k *= -1;
			}
			if (nums[k] > 0)
			{
				// 把对应位置给反转了
				nums[k] *= -1;
			}
		}
		for (int i = 1; i < len; i++)
		{
			if (nums[i] > 0)
			{
				return i;
			}
		}
		if (nums[0] > 0)
		{
			return len;
		}
		return len + 1;
	}
}
