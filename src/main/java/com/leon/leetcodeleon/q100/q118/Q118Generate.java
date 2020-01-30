package com.leon.leetcodeleon.q100.q118;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q118Generate
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(generate(1)));
		System.out.println(JSONObject.toJSONString(generate(2)));
		System.out.println(JSONObject.toJSONString(generate(5)));
	}

	public List<List<Integer>> generate(int numRows)
	{
		if (numRows <= 0)
		{
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>(1);
		tmp.add(1);
		res.add(tmp);
		for (int i = 1; i < numRows; i++)
		{
			tmp = new ArrayList<>();
			tmp.add(1);
			for (int j = 1; j < res.get(i - 1).size(); j++)
			{
				tmp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
			}
			tmp.add(1);
			res.add(tmp);
		}
		return res;
	}
}
