package com.leon.leetcodeleon.q000.q066;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q066PlusOne
{
	@Test
	public void test()
	{
		// plusOne(new int[] { 1, 2, 3 });
		plusOne(new int[] { 8, 9 });
		// plusOne(new int[] { 9 });
	}

	public int[] plusOne(int[] digits)
	{
		if (digits == null || digits.length <= 0)
		{
			return digits;
		}
		List<Integer> tmp = new ArrayList<>();
		for (int i = digits.length - 1; i >= 0; i--)
		{
			tmp.add(digits[i]);
		}
		int carray = 0;
		tmp.set(0, tmp.get(0) + 1);

		for (int i = 0; i < tmp.size(); i++)
		{
			tmp.set(i, tmp.get(i) + carray);
			if (tmp.get(i) >= 10)
			{
				carray = 1;
				tmp.set(i, tmp.get(i) - 10);
			}
			else
			{
				carray = 0;
			}
		}
		if (carray > 0)
		{
			tmp.add(1);
		}

		int[] rs = new int[tmp.size()];
		int k = 0;
		for (int i = tmp.size() - 1; i >= 0; i--)
		{
			rs[k++] = tmp.get(i);
		}
		System.out.println(JSONObject.toJSONString(rs));
		return rs;
	}
}
