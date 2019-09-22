package com.leon.leetcodeleon.q0.q01;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Question01SumNum
{
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int k = 0;
		for (int num : nums)
		{
			map.put(target - num, k++);
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (map.containsKey(nums[i]) && i != map.get(nums[i]))
			{
				return new int[] { i, map.get(nums[i]) };
			}
		}

		return null;
	}

	public static void main(String[] args)
	{
		Question01SumNum q = new Question01SumNum();
		int[] nums = new int[] { 3, 2, 4 };
		int target = 6;
		int[] ints = q.twoSum(nums, target);
		System.out.println(JSONObject.toJSONString(ints));
	}
}
