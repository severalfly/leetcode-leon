package com.leon.leetcodeleon.q400.q466;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q466GetMaxRepetitions extends BaseTest
{
	@Test
	public void test()
	{
		// assert getMaxRepetitions("acb", 1, "acb", 1) == 1;
		// assert getMaxRepetitions("abdbec", 1, "abc", 1) == 1;
		assert getMaxRepetitions("acb", 4, "ab", 2) == 2;
		assert getMaxRepetitions("aaa", 4, "a", 2) == 6;
		assert getMaxRepetitions("aaa", 4, "a", 3) == 4;
	}

	public int getMaxRepetitions(String s1, int n1, String s2, int n2)
	{
		// if (n1 == 0 || n2 == 0)
		// {
		// 	return 0;
		// }
		// String t1 = "";
		// for (int i = 0; i < n1; i++)
		// {
		// 	t1 += s1;
		// }
		// String t2 = "";
		// for (int i = 0; i < n2; i++)
		// {
		// 	t2 += s2;
		// }
		// int m = t1.length();
		// int n = t2.length();
		// int[] dp = new int[m];
		// for (int i = 0; i < m; i++)
		// {
		// 	if (t1.charAt(i) == t2.charAt(0))
		// 	{
		// 		dp[i] = 1;
		// 	}
		// }
		// print(dp);
		// for (int j = 1; j < n; j++)
		// {
		// 	// dp[0] = t1.charAt(0) == t2.charAt(j) ? 1 : 0;
		// 	for (int i = 1; i < m; i++)
		// 	{
		// 		int max = Math.max(dp[i - 1], dp[i]);
		// 		if (t1.charAt(i) == t2.charAt(j))
		// 		{
		// 			max++;
		// 		}
		// 		dp[i] = max;
		// 	}
		// 	print(dp);
		// }
		// print(dp);
		// int res = dp[m - 1] / n2 / s2.length();
		// System.out.println(res);
		// return res;
		return 0;
	}

	private void print(int[] dp)
	{
		ObjectUtils.print(dp);
	}
}
