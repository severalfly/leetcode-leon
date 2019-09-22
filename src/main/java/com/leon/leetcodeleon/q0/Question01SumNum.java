package com.leon.leetcodeleon.q0;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class Question01SumNum
{
	public int[] twoSum(int[] nums, int target)
	{
		if (nums == null)
		{
			return null;
		}
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		while (j > i)
		{
			int sum = nums[i] + nums[j];
			if (sum == target)
			{
				break;
			}
			else if (sum > target)
			{
				j--;
			}
			else
			{
				i++;
			}
		}
		return new int[] { i, j };
	}

	public static void main(String[] args)
	{
		Question01SumNum q = new Question01SumNum();
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] ints = q.twoSum(nums, target);
		System.out.println(JSONObject.toJSONString(ints));
	}
}
