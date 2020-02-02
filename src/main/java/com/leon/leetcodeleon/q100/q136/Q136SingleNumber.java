package com.leon.leetcodeleon.q100.q136;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q136SingleNumber extends BaseTest
{
	@Test
	public void test()
	{
		assert singleNumber(new int[] { 2, 2, 1 }) == 1;
		assert singleNumber(new int[] { 2 }) == 2;
		assert singleNumber(new int[] { 4, 1, 2, 1, 2 }) == 4;
	}

	public int singleNumber(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return 0;
		}
		if (nums.length == 1)
		{
			return nums[0];
		}
		int res = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			res ^= nums[i];
		}
		return res;
	}
}
