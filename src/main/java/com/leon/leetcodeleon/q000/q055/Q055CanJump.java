package com.leon.leetcodeleon.q000.q055;

import org.junit.Test;

public class Q055CanJump
{
	@Test
	public void test()
	{
		assert canJump(new int[] { 2, 3, 1, 1, 4 }) == true;
		assert canJump(new int[] { 3, 2, 1, 0, 4 }) == false;
	}

	public boolean canJump(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return false;
		}
		int len = nums.length;
		int last = len - 1;
		// int i = last;
		while (last > 0)
		{
			boolean c = false;
			for (int i = 0; i < last; i++)
			{
				if (nums[i] >= last - i)
				{
					last = i;
					c = true;
					break;
				}
			}
			if (!c)
			{
				return false;
			}
		}
		return true;
	}
}
