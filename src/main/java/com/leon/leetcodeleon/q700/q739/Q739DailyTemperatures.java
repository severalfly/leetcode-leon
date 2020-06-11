package com.leon.leetcodeleon.q700.q739;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Stack;

/**
 * @Package com.leon.leetcodeleon.q700.q739
 * @author zhangyunfei
 * @date 2020-06-11 21:04
 * @version V1.0
 */
public class Q739DailyTemperatures
{
	@Test
	public void test()
	{
		System.out.println(JSONObject.toJSONString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}

	public int[] dailyTemperatures(int[] T)
	{
		int len = T.length;
		int[] res = new int[len];
		Stack<Integer> indexStack = new Stack<>();
		for (int i = 0; i < len; i++)
		{
			while (indexStack.size() > 0 && T[i] > T[indexStack.peek()])
			{
				int p = indexStack.pop();
				res[p] = i - p;
			}

			indexStack.push(i);
		}
		return res;
	}
}
