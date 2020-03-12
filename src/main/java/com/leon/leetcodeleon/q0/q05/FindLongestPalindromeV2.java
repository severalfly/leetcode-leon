package com.leon.leetcodeleon.q0.q05;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class FindLongestPalindromeV2 extends BaseTest
{
	private String str1 = "babad";

	@Test
	public void test()
	{
		// assert longestPalindrome("a").equalsIgnoreCase("a");
		// String s = longestPalindrome(str1);
		// assert s.equalsIgnoreCase("bab") || s.equalsIgnoreCase("aba");
		// assert longestPalindrome("cbbd").equalsIgnoreCase("bb");
		assert longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").equalsIgnoreCase("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assert longestPalindrome("cbbeed").equalsIgnoreCase("bb") || longestPalindrome("cbbeed").equalsIgnoreCase("ee");
		assert longestPalindrome("civic").equalsIgnoreCase("civic");
	}

	public String longestPalindrome(String s)
	{
		if (s == null || s.length() <= 0)
		{
			return "";
		}
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++)
		{
			dp[0][i] = true;
		}

		int max = 1;
		String res = s.substring(0, 1);
		if (s.length() >= 2)
		{
			for (int i = 0; i < s.length() - 1; i++)
			{
				if (s.charAt(i) == s.charAt(i + 1))
				{
					dp[1][i] = true;
					max = 2;
					res = s.substring(i, i + 2);
				}
			}
		}
		for (int n = 3; n <= s.length(); n++)
		{
			int start = (n - 1) / 2;
			for (int i = start; i < s.length() - n / 2; i++)
			{
				int l = i - start;
				int r = i + start;
				if (n % 2 == 0)
				{
					r++;
				}
				if (dp[n - 2 - 1][i] && s.charAt(l) == s.charAt(r))
				{
					if (max < n)
					{
						max = n;
						res = s.substring(l, r + 1);
					}
					dp[n - 1][i] = true;
				}
			}
		}
		return res;
	}

}
