package com.leon.leetcodeleon.q100.q152;

import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q100.q152
 * @author zhangyunfei
 * @date 2020-05-18 08:12
 * @version V1.0
 */
public class Q152MaxProduct
{
	@Test
	public void test()
	{
		// assert maxProduct(new int[] { 2, 3, -2, 4 }) == 6;
		assert maxProduct(new int[] { 2, 3, -2, 4, -2 }) == 96;
		// assert maxProduct(new int[] { -2, 0, -1 }) == 0;
	}

	public int maxProduct(int[] nums)
	{

		int maxF = nums[0];
		int minF = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++)
		{
			int max = maxF;
			int min = minF;
			maxF = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
			minF = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
			res = Math.max(maxF, res);
		}
		return res;
	}
}
