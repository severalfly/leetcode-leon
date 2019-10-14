package com.leon.leetcodeleon.q000.q018;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

public class Q018FourNumSum
{
	@Test
	public void test()
	{
//		assert fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0).size() == 3;
		assert fourSum(new int[] { -3,-2,-1,0,0,1,2,3 }, 0).size() == 3;
	}

	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		if (nums == null || nums.length < 4)
		{
			return new ArrayList<>();
		}
		//		List<List<Integer>> res = new ArrayList<>();
		Set<List<Integer>> res = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++)
		{
			for (int j = i + 1; j < nums.length - 2; j++)
			{
				int k = j + 1;
				int l = nums.length - 1;
				while (k < l)
				{
					int sum = add(nums, i, j, k, l);
					if (sum == target)
					{
						// 一个结果
						res.add(fill(nums, i, j, k, l));
						l--;
					}
					else if (sum > target)
					{
						l--;
					}
					else
					{
						k++;
					}
				}
			}
		}
		System.out.println(JSONObject.toJSONString(res));
		return new ArrayList<>(res);
//		resList.addAll(res);
//		return resList;
	}

	private int add(int[] nums, int i, int j, int k, int l)
	{
		return nums[i] + nums[j] + nums[k] + nums[l];
	}

	private List<Integer> fill(int[] nums, int i, int j, int k, int l)
	{
		List<Integer> res = new ArrayList<>();
		res.add(nums[i]);
		res.add(nums[j]);
		res.add(nums[k]);
		res.add(nums[l]);
		return res;

	}
}
