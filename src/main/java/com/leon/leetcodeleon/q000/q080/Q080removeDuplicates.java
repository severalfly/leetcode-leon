package com.leon.leetcodeleon.q000.q080;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Q080removeDuplicates
{
	@Test
	public void test()
	{
		assert removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }) == 7;
		assert removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }) == 5;
	}

	public int removeDuplicates(int[] nums)
	{
		if (nums == null || nums.length <= 0)
		{
			return 0;
		}
		else if (nums.length <= 2)
		{
			return nums.length;
		}
		int left = 1;
		int right = 1;
		int count = 1;

		while (right < nums.length)
		{
			if (nums[right] == nums[right - 1])
			{
				count++;
			}
			else
			{
				count = 1;
			}
			if (count <= 2)
			{
				nums[left++] = nums[right];
			}
			right++;
		}
		System.out.println(JSONObject.toJSONString(nums));
		return left;
	}
}
