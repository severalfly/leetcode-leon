package com.leon.leetcodeleon.q000.q075;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Q075SortColors
{
	@Test
	public void test()
	{
		sortColors(new int[] { 2, 0, 1 });
		sortColors(new int[] { 2, 0, 2, 1, 1, 0,1,2,1,2,1,2,1,2,1 });
	}

	public void sortColors(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return;
		}
		int left = 0;
		int p = 0;
		int right = nums.length - 1;
		while (left <= right && p <= right)
		{
			if (nums[p] == 0)
			{
				swap(nums, left, p);
				left++;
				p++;
			}
			else if (nums[p] == 2)
			{
				swap(nums, p, right);
				// p++;
				right--;
			}
			else
			{
				p++;
			}
		}
		System.out.println(JSONObject.toJSONString(nums));
	}

	private void swap(int[] nums, int l, int r)
	{
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
}
