package com.leon.leetcodeleon.q000.q097;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q097IsInterleave extends BaseTest
{
	@Test
	public void test()
	{
		assert isInterleave("abc", "df", "abdfc");
		// assert isInterleave("aabcc", "dbbca", "aadbbcbcac");
		// assert !isInterleave("aabcc", "dbbca", "aadbbbaccc");
	}

	public boolean isInterleave(String s1, String s2, String s3)
	{
		if (s3.length() != s2.length() + s1.length())
		{
			return false;
		}

		boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++)
		{
			for (int j = 0; j <= s2.length(); j++)
			{
				if (i == 0 && j == 0)
				{
					dp[i][j] = true;
				}
				else if (i == 0)
				{
					dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
				}
				else if (j == 0)
				{
					dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
				}
				else
				{
					dp[i][j] = (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) || (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
				}
			}
		}
		ObjectUtils.print(dp);
		return dp[s1.length()][s2.length()];
	}
}
