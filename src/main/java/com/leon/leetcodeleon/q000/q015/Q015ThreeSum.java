package com.leon.leetcodeleon.q000.q015;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q015ThreeSum extends BaseTest
{
	@Test
	public void test()
	{
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
		System.out.println(threeSum(new int[]{}));
	}

	public List<List<Integer>> threeSum(int[] nums)
	{
		if (nums == null || nums.length < 3)
		{
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		//		System.out.println(JSONObject.toJSONString(nums));
		for (int k = 0; k < nums.length - 2;) // 固定一个位置，再使用双指针的方法求解
		{
			int i = k + 1;
			int j = nums.length - 1;
			while (i < j)
			{
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0)
				{
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					res.add(list);
					do
					{
						j--;
					}
					while (i < j && nums[j + 1] == nums[j]);
					do
					{
						i++;
					}
					while (i < j && nums[i - 1] == nums[i]);
				}
				else if (sum > 0)
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
			do
			{
				k++;
			}
			while (k<nums.length-2 && nums[k - 1] == nums[k]);
		}
		return res;
	}
}
