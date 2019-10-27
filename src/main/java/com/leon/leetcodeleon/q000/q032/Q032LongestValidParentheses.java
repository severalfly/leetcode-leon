package com.leon.leetcodeleon.q000.q032;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q032LongestValidParentheses extends BaseTest
{
	@Test
	public void test()
	{
				assert longestValidParentheses("(()") == 2;
				assert longestValidParentheses(")()())") == 4;
				assert longestValidParentheses("(") == 0;
				assert longestValidParentheses("()(()") == 2;
		assert longestValidParentheses("(()") == 2;
	}

	public int longestValidParentheses(String s)
	{
		if (s == null || s.length() <= 0)
		{
			return 0;
		}

		int lgst1 = getLgst(s, '(', ')');
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--)
		{
			sb.append(s.charAt(i));
		}
		int lgst2 = getLgst(sb.toString(), ')', '(');
//		System.out.println(lgst1 + " " + lgst2);
		return lgst1 > lgst2 ? lgst1 : lgst2;
	}

	private int getLgst(String s, char c1, char c2)
	{
		int lgst = 0;
		//		int start = 0;
		int count = 0;// ( 的个数
		int res = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == c1)
			{
				count++;
			}
			else if (s.charAt(i) == c2)
			{
				if (count > 0)
				{
					res += 2;
					count--;
				}
				else
				{
					res = 0;
				}
			}
			if (count <= 0 && res > lgst)
			{
				lgst = res;
			}
		}
		return lgst;
	}
}
