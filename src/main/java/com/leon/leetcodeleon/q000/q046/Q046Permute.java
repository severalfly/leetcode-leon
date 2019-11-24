package com.leon.leetcodeleon.q000.q046;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q046Permute
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(permute(new int[] { 1, 2, 3 })));
	}

	public List<List<Integer>> permute(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length <= 0)
		{
			return res;
		}
		List<Integer> list = new ArrayList<>();

		list.add(nums[0]);
		res.add(list);
		if (nums.length == 1)
		{
			return res;
		}

		for (int k = 1; k < nums.length; k++)
		{
			int key = nums[k];
			List<List<Integer>> tmp = new ArrayList<>();

			for (int i = 0; i < res.size(); i++)
			{
				List<Integer> integers = res.get(i);
				for (int j = 0; j < integers.size() + 1; j++)
				{
					List<Integer> insert = insert(integers, j, key);
					tmp.add(insert);
				}
			}
			res = tmp;
		}
		return res;
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

	@Test
	public void testInsert()
	{
		List<Integer> list = new ArrayList<>();
		List<Integer> insert = insert(list, 0, 1);
		insert = insert(insert, 1, 3);
		insert = insert(insert, 0, 2);
		System.out.println(JSONObject.toJSONString(insert));
	}

}
