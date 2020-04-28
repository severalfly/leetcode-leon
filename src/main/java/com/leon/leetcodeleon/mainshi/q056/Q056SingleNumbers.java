package com.leon.leetcodeleon.mainshi.q056;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Q056SingleNumbers
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(singleNumbers(new int[] { 4, 1, 4, 6 })));
		System.out.println(JSONObject.toJSONString(singleNumbers(new int[] { 1, 2, 10, 4, 1, 4, 3, 3 })));
	}

	public int[] singleNumbers(int[] nums)
	{

		int ret = 0;
		for (int n : nums)
		{
			ret ^= n;
		}
		int div = 1;
		while ((div & ret) == 0)
		{
			div <<= 1;
		}
		int a = 0;
		int b = 0;
		for (int n : nums)
		{
			if ((n & div) == 0)
			{
				a ^= n;
			}
			else
			{
				b ^= n;
			}
		}
		int[] res = new int[2];
		res[0] = a;
		res[1] = b;
		return res;
	}
}
