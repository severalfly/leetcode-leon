package com.leon.leetcodeleon.q000.q045;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q045JumpSecondVersion extends BaseTest
{
	@Test
	public void test()
	{
		assert jump(new int[] { 2, 3, 1, 1, 4 }) == 2;
	}

	public int jump(int[] nums)
	{
		int last = nums.length - 1;
		int steps = 0;
		while (last > 0)
		{
			for (int i = 0; i < last; i++)
			{
				if (nums[i] >= last - i)
				{
					last = i;
					steps++;
					break;
				}
			}
		}
		return steps;
	}
}
