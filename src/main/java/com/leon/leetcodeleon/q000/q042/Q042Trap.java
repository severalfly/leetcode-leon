package com.leon.leetcodeleon.q000.q042;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q042Trap extends BaseTest
{
	@Test
	public void test()
	{
		// assert trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }) == 6;
		assert trap(new int[] { 2, 0, 2 }) == 2;
	}

	public int trap(int[] height)
	{
		if (height == null || height.length <= 1)
		{
			return 0;
		}
		int sum = 0;
		for (int i = 1; i < height.length; i++)
		{
			int midMax = 0; // 向前循环过程中遇到的最大值，因为 k-1 时，如果值是小于 midMax 时，不可能对 i 处产生影响
			for (int k = i - 1; k >= 0; k--)
			{
				if (height[k] > midMax && height[i] > 0)
				{
					int w = i - k - 1;
					int h = Math.min(height[i], height[k]) - midMax;
					System.out.println("s: " + k + " e: " + i + " = " + w * h);
					sum += w * h;
					midMax = height[k];
				}
				if (height[k] >= height[i])
				{
					break;
				}
			}
		}
		// System.out.println(sum);
		return sum;
	}
}
