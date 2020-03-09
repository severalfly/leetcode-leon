package com.leon.leetcodeleon.q000.q084;

import org.junit.Test;

public class Q084LargestRectangleArea
{
	@Test
	public void test()
	{
		assert largestRectangleArea2(new int[] { 2, 1, 5, 6, 2, 3 }) == 10;
		assert largestRectangleArea2(new int[] { 2 }) == 2;
	}

	public int largestRectangleArea(int[] heights)
	{
		return 0;
	}

	/**
	 * 分治法
	 * @param heights
	 * @return
	 */
	private int largestRectangleArea1(int[] heights)
	{
		return 0;
	}

	/**
	 * 暴力法
	 * @param heights
	 * @return
	 */
	private int largestRectangleArea2(int[] heights)
	{
		if (heights == null || heights.length <= 0)
		{
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++)
		{
			int minHeight = heights[i];
			for (int j = i; j < heights.length; j++)
			{
				if (minHeight > heights[j])
				{
					minHeight = heights[j];
				}
				int area = minHeight * (j - i + 1);
				if (area > max)
				{
					max = area;
				}
			}
		}
		return max;
	}

	/**
	 * 进出栈
	 * @param heights
	 * @return
	 */
	private int largestRectangleArea3(int[] heights)
	{
		return 0;
	}

}
