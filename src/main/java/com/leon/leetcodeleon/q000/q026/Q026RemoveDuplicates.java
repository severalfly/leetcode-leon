package com.leon.leetcodeleon.q000.q026;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.junit.Test;

public class Q026RemoveDuplicates
{

	@Test
	public void test()
	{
		assert removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }) == 5;
	}

	public int removeDuplicates(int[] nums)
	{
		if (nums.length <= 1)
		{
			return nums.length;
		}
		int i = 1;
		for (int k = 1; k < nums.length; k++)
		{
			if (nums[k] != nums[k - 1])
			{
				nums[i++] = nums[k];
			}
		}
//		System.out.println(JSONObject.toJSONString(nums));
		return i;
	}
}
