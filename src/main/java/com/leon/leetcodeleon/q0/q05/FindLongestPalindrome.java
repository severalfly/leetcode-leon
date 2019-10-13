package com.leon.leetcodeleon.q0.q05;

import org.junit.Test;

public class FindLongestPalindrome
{
	private String str1 = "babad";
	private String str2 = "cbbd";

	@Test
	public void test()
	{
		assert longestPalindrome("a").equalsIgnoreCase("a");
		String s = longestPalindrome(str1);
		assert s.equalsIgnoreCase("bab") || s.equalsIgnoreCase("aba");
		assert longestPalindrome(str2).equalsIgnoreCase("bb");
	}

	public String longestPalindrome(String s)
	{
		if (s == null || s.length() <= 1)
		{
			return s;
		}
		s = expandStr(s);
		String res = "";
		for (int i = 0; i < s.length() - 2; i++)
		{
			int k = i;
			int l = i;
			while (k >= 0 && l < s.length())
			{
				if (s.charAt(k) != s.charAt(l))
				{
					break;
				}
				String substring = s.substring(k, l + 1);
				if (substring.length() > res.length())
				{
					res = substring;
				}
				k--;
				l++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length(); i++)
		{
			if (res.charAt(i) != '#')
			{
				sb.append(res.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * 使用 # 填充
	 * @param s
	 * @return
	 */
	private String expandStr(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			sb.append(s.charAt(i));
			sb.append("#");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}
}
