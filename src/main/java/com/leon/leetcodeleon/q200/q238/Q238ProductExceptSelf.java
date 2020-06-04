package com.leon.leetcodeleon.q200.q238;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q200.q238
 * @author zhangyunfei
 * @date 2020-06-04 20:07
 * @version V1.0
 */
public class Q238ProductExceptSelf
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
		System.out.println(JSONObject.toJSONString(productExceptSelf(new int[] { 9, 0, -2 })));
	}

	public int[] productExceptSelf(int[] nums)
	{
		int[] l = new int[nums.length];
		l[0] = 1;
		for (int i = 1; i < nums.length; i++)
		{
			l[i] = l[i - 1] * nums[i - 1];
		}
		int[] r = new int[nums.length];
		r[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--)
		{
			r[i] = r[i + 1] * nums[i + 1];
		}
		System.out.println(JSONObject.toJSONString(l));
		System.out.println(JSONObject.toJSONString(r));

		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			res[i] = l[i] * r[i];
		}
		return res;

	}
}
