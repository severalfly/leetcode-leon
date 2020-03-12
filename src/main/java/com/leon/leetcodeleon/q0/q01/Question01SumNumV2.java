package com.leon.leetcodeleon.q0.q01;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question01SumNumV2
{
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			map.put(target - nums[i], i);
		}
		for (int i = 0; i < nums.length; i++)
		{
			if (map.containsKey(nums[i]) && map.get(nums[i]) != i)
			{
				int[] res = new int[2];
				res[0] = map.get(nums[i]);
				res[1] = i;
				return res;
			}
		}
		return null;

	}

	public static void main(String[] args)
	{
		Question01SumNumV2 q = new Question01SumNumV2();
		int[] nums = new int[] { 3, 2, 4 };
		int target = 6;
		int[] ints = q.twoSum(nums, target);
		System.out.println(JSONObject.toJSONString(ints));
	}
}
