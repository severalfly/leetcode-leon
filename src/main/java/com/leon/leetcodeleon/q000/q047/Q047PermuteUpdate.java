package com.leon.leetcodeleon.q000.q047;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q047PermuteUpdate
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(permuteUnique(new int[] { 1, 1, 2 })));
	}

	public List<List<Integer>> permuteUnique(int[] nums)
	{
		Set<List<Integer>> res = new HashSet<>();
		if (nums == null || nums.length <= 0)
		{

			return new ArrayList<>(0);
		}
		List<Integer> list = new ArrayList<>();

		list.add(nums[0]);
		res.add(list);
		if (nums.length == 1)
		{
			return new ArrayList<>(res);
		}

		for (int k = 1; k < nums.length; k++)
		{
			int key = nums[k];
			Set<List<Integer>> tmp = new HashSet<>();

			for (List<Integer> integers:res)
			{
				// List<Integer> integers = res.get(i);
				for (int j = 0; j < integers.size() + 1; j++)
				{
					List<Integer> insert = insert(integers, j, key);
					tmp.add(insert);
				}
			}
			res = tmp;
		}
		return new ArrayList<>(res);
	}

	private List<Integer> insert(List<Integer> res, int index, int key)
	{
		if (res == null)
		{
			return res;
		}
		List<Integer> list = new ArrayList<>();
		if (res.size() == 0)
		{
			list.add(key);
			return list;
		}

		for (int i = 0; i < res.size(); i++)
		{
			if (i != index)
			{
				list.add(res.get(i));
			}
			else
			{
				list.add(key);
				list.add(res.get(i));
			}
		}
		if (res.size() == index)
		{
			list.add(key);
		}
		return list;
	}
}
