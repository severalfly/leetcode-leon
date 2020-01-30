package com.leon.leetcodeleon.q100.q119;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q119GetRow
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(getRow(0)));
		System.out.println(JSONObject.toJSONString(getRow(1)));
		System.out.println(JSONObject.toJSONString(getRow(2)));
		System.out.println(JSONObject.toJSONString(getRow(3)));
		System.out.println(JSONObject.toJSONString(getRow(5)));

	}

	public List<Integer> getRow(int rowIndex)
	{
		rowIndex++;
		if (rowIndex <= 0)
		{
			return new ArrayList<>();
		}
		List<Integer> res = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>(1);
		tmp.add(1);
		res = tmp;
		for (int i = 1; i < rowIndex; i++)
		{
			tmp = new ArrayList<>();
			tmp.add(1);
			for (int j = 1; j < res.size(); j++)
			{
				tmp.add(res.get(j) + res.get(j - 1));
			}
			tmp.add(1);
			res = tmp;
		}
		return res;
	}
}
