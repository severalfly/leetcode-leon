package com.leon.leetcodeleon.q000.q016;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.Arrays;

public class Q016ThreeSumClosest extends BaseTest
{
	@Test
	public void test()
	{
		assert threeSumClosest(new int[] { 0, 0, 0 }, 1) == 0;
		assert threeSumClosest(new int[] { 0, 1, 2 }, 0) == 3;
		assert threeSumClosest(new int[] { -3, -2, -5, 3, -4 }, -1) == -2;
		assert threeSumClosest(new int[] { 0, 2, 1, -3 }, 1) == 0;
		assert threeSumClosest(new int[] { 1, 2, 4, 8, 16, 32, 64, 128 }, 82) == 82;
		assert threeSumClosest(new int[] { -1, 2, 1, -4 }, 1) == 2;
		assert threeSumClosest(
				new int[] { -100, -99, -99, -99, -96, -95, -94, -94, -92, -90, -90, -89, -86, -86, -85, -83, -82, -80, -78, -78, -77, -76, -76, -74, -74, -73, -72, -72, -71, -71, -70, -70, -69, -67, -66, -61, -60, -60, -58, -56, -55, -53, -53, -53, -51, -48, -48, -47, -46, -44, -42, -36, -35, -33,
						-33, -32, -32, -30, -30, -29, -27, -27, -23, -22, -19, -18, -18, -16, -16, -13, -10, -8, -8, -4, -4, -3, -2, 0, 0, 0, 1, 3, 3, 4, 4, 5, 9, 9, 9, 9, 10, 11, 11, 12, 13, 17, 18, 18, 18, 19, 20, 21, 22, 22, 23, 23, 23, 24, 24, 24, 24, 28, 28, 30, 31, 32, 32, 39, 39, 41, 44, 45,
						47, 49, 50, 50, 52, 54, 54, 54, 55, 57, 61, 62, 62, 67, 67, 67, 68, 69, 69, 78, 79, 80, 80, 82, 82, 83, 83, 85, 86, 87, 88, 90, 91, 91, 91, 91, 91, 96, 97, 98 }, 298) == 291;
	}

	public int threeSumClosest(int[] nums, int target)
	{
		if (nums == null || nums.length < 3)
		{
			return 0;
		}
		Arrays.sort(nums);
		//		System.out.println(JSONObject.toJSONString(nums));
		//		int m = 0, n = 1, l = 2;
		int closest = target >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		//		System.out.println(JSONObject.toJSONString(nums));
		for (int k = 0; k < nums.length - 2; k++) // 固定一个位置，再使用双指针的方法求解
		{
			int i = k + 1;
			int j = nums.length - 1;
			while (i < j)
			{
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target)
				{
					return sum;
				}
				else if (Math.abs(sum - target) <= Math.abs(closest - target))
				{
					if (sum > target)
					{
						do
						{
							j--;
						}
						while (i < j && nums[j + 1] == nums[j]);
					}
					else
					{
						do
						{
							i++;
						}
						while (i < j && nums[i - 1] == nums[i]);
					}
					//					m = i;
					//					n = j;
					//					l = k;
					closest = sum;
				}
				else
				{
					if (sum > target)
					{
						do
						{
							j--;
						}
						while (i < j && nums[j + 1] == nums[j]);
					}
					else
					{
						do
						{
							i++;
						}
						while (i < j && nums[i - 1] == nums[i]);
					}

				}
			}
		}

		//		System.out.println(m + " " + n + " " + l);
		return closest;
	}
}
