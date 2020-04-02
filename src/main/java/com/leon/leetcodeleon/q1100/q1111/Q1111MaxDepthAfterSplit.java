package com.leon.leetcodeleon.q1100.q1111;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class Q1111MaxDepthAfterSplit
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(maxDepthAfterSplit("(()())")));
		System.out.println(JSONObject.toJSONString(maxDepthAfterSplit("()(())()")));
	}

	public int[] maxDepthAfterSplit(String seq)
	{
		// int[] res = new int[seq.length()];
		// int d = 0;
		// for (int i = 0; i < seq.length(); i++)
		// {
		// 	char c = seq.charAt(i);
		// 	if (c == '(')
		// 	{
		// 		d++;
		// 	}
		// 	else
		// 	{
		// 		d--;
		// 	}
		// 	res[i] = d % 2;
		// }
		// return res;

		int d = 0;
		int[] ans = new int[seq.length()];
		for (int i = 0; i < seq.length(); i++)
		{
			char c = seq.charAt(i);
			if (c == '(')
			{
				++d;
				ans[i] = (d % 2);
			}
			else
			{
				ans[i] = (d % 2);
				--d;
			}
		}
		return ans;

	}
}
