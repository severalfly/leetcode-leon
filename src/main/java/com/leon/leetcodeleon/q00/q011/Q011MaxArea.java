package com.leon.leetcodeleon.q00.q011;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Q011MaxArea
{
	@Test
	public void test()
	{
//		assert maxAreaV2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7, 1, 8, 6, 2, 5, 4, 8, 3, 7 }) == 112;
		assert maxAreaV2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }) == 49;
		assert maxAreaV2(new int[] { 1, 1 }) == 1;
		assert maxAreaV2(new int[] { 1, 2, 1 }) == 2;
	}

	public int maxAreaV2(int[] height)
	{
		int i = 0;
		int j = height.length - 1;
		int max = 0;
		while (i < j)
		{
			max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			if(height[i] < height[j])
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		System.out.println(max);
		return max;
	}

	public int maxArea(int[] height)
	{
		int k = 0;
		int max = 0;
		for (int l = 2; l <= height.length; l++)
		{
			for (int i = 0; i < height.length - l + 1; i++)
			{
				k++;
				int j = i + l - 1;
				int q = Math.min(height[i], height[j]) * (j - i);
				if (q > max)
				{
					max = q;
				}
				//				tmp[i][j] = q;
			}
		}
		System.out.println(k);
		System.out.println(max);
		return max;
	}
}
