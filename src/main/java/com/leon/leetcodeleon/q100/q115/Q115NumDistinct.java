package com.leon.leetcodeleon.q100.q115;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q115NumDistinct extends BaseTest
{

	@Test
	public void test()
	{
		assert numDistinct("rabbbit", "rabbit") == 3;
		assert numDistinct("babgbag", "bag") == 5;
	}

	public int numDistinct(String s, String t)
	{
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		for (int j = 0; j < s.length(); j++)
		{
			dp[0][j] = 1;
		}

		for (int i = 1; i < t.length() + 1; i++)
		{
			for (int j = 1; j < s.length() + 1; j++)
			{
				if (s.charAt(j - 1) == t.charAt(i - 1))
				{
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				}
				else
				{
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[t.length()][s.length()];
	}
}
