package com.leon.leetcodeleon.q000.q031;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q031NextPuermutation extends BaseTest
{
	@Test
	public void test()
	{
		int[] a = new int[] { 1, 2, 3 };
		nextPermutation(a);
		System.out.println(JSONObject.toJSONString(a));

		int[] b = new int[] { 3, 2, 1 };
		nextPermutation(b);
		System.out.println(JSONObject.toJSONString(b));

		int[] c = new int[] { 1, 1, 5 };
		nextPermutation(c);
		System.out.println(JSONObject.toJSONString(c));
	}

	public void nextPermutation(int[] nums)
	{

		if (nums == null || nums.length <= 1)
		{
			return;
		}
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i])
		{
			i--;
		}
		if (i >= 0)
		{
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i])
			{
				j--;
			}
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
		reverse(nums, i + 1, nums.length - 1);

	}

	private void reverse(int[] nums, int l, int r)
	{
		while (l < r)
		{
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}
}
