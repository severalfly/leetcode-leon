package com.leon.leetcodeleon.q1300.q1389;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1389CreateTargetArray
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 2, 1 })));
		System.out.println(JSONObject.toJSONString(createTargetArray(new int[] { 1, 2, 3, 4, 0 }, new int[] { 0, 1, 2, 3, 0 })));
	}

	public int[] createTargetArray(int[] nums, int[] index)
	{
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			list.add(index[i], nums[i]);
		}
		int[] res = new int[list.size()];

		for (int i = 0; i < list.size(); i++)
		{
			res[i] = list.get(i);
		}
		return res;

	}

}
