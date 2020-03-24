package com.leon.leetcodeleon.q000.q022;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.*;

public class Q022GenerateParenthesisV2 extends BaseTest
{
	@Test
	public void test()
	{
		assert generateParenthesis(1).size() == 1;
		assert generateParenthesis(2).size() == 2;
		assert generateParenthesis(3).size() == 5;
		assert generateParenthesis(4).size() == 14;

	}

	public List<String> generateParenthesis(int n)
	{
		List<String> ans = new ArrayList();
		backtrack(ans, "", 0, 0, n);
		return ans;

	}

	private void backtrack(List<String> ans, String cur, int open, int close, int max)
	{
		if (cur.length() == max * 2)
		{
			ans.add(cur);
			return;
		}

		if (open < max)
			backtrack(ans, cur + "(", open + 1, close, max);
		if (close < open)
			backtrack(ans, cur + ")", open, close + 1, max);

	}
}
