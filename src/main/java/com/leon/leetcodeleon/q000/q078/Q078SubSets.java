package com.leon.leetcodeleon.q000.q078;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q078SubSets
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(subsets(new int[] { 1, 2, 3 })));
		System.out.println(JSONObject.toJSONString(subsets(new int[] {})));
	}

	public List<List<Integer>> subsets(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		backtrace(0, nums, new ArrayList<>(), res);
		res.add(new ArrayList<>());
		return res;
	}

	public void backtrace(int start, int[] nums, List<Integer> tmp, List<List<Integer>> res)
	{
		for (int i = start; i < nums.length; i++)
		{
			tmp.add(nums[i]);
			List<Integer> t = new ArrayList<>(tmp);
			res.add(t);
			backtrace(i + 1, nums, tmp, res);
			tmp.remove(tmp.size() - 1);
		}
	}

}
