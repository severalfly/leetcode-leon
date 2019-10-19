package com.leon.leetcodeleon.q000.q022;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q022GenerateParenthesis extends BaseTest
{
	@Test
	public void test()
	{
//		assert generateParenthesis(1).size() == 1;
//		assert generateParenthesis(2).size() == 2;
//		assert generateParenthesis(3).size() == 5;
		assert generateParenthesis(4).size() == 14;

	}

	public List<String> generateParenthesis(int n)
	{
		if (n <= 0)
		{
			return new ArrayList<>(0);
		}
		List<String> per = new ArrayList<>();
		per.add("()");
		if (n == 1)
		{
			return per;
		}

		for (int i = 2; i <= n; i++)
		{
			Set<String> tmpSet = new HashSet<>();
			for (String s : per)
			{
				String tmp = "(" + s;
				for (int j = 1; j < tmp.length(); j++)
				{
					tmpSet.add(tmp.substring(0, j) + ")" + tmp.substring(j));
				}
			}
			per = new ArrayList<>(tmpSet);
		}
		Collections.sort(per);
//		System.out.println(JSONObject.toJSONString(per));
		return per;

	}
}
