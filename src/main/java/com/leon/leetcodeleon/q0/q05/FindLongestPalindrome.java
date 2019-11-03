package com.leon.leetcodeleon.q0.q05;

import com.alibaba.fastjson.JSONObject;
import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class FindLongestPalindrome extends BaseTest
{
	private String str1 = "babad";
	private String str2 = "cbbd";

	@Test
	public void test()
	{
		//		assert longestPalindrome("a").equalsIgnoreCase("a");
		//		String s = longestPalindrome(str1);
		//		assert s.equalsIgnoreCase("bab") || s.equalsIgnoreCase("aba");
		//		assert longestPalindrome(str2).equalsIgnoreCase("bb");
		//		assert longestPalindromeV2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").equalsIgnoreCase("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assert longestPalindromeV2(str2).equalsIgnoreCase("bb");
		assert longestPalindromeV2("asdfghjkwtcivic").equalsIgnoreCase("civic");
	}

	/**
	 * 使用动态规划方法
	 */
	public String longestPalindromeV2(String s)
	{
		if (s == null || s.length() <= 1)
		{
			return s;
		}
		s = expandStr(s);
		int len = s.length();
		int[][] pal = new int[len][len + 1];
		for (int i = 0; i < len; i++)
		{
			//			for (int j = 0; j < len; j++)
			pal[i][1] = 1;
		}
		int maxLen = 0;
		int lastJ = -1;
		for (int l = 2; l <= len; l++)
		{
			for (int j = l / 2; j < len - l / 2; j++)
			{
				if (pal[j][l - 1] == 1 && s.charAt(j - l / 2) == s.charAt(j + l / 2))
				{
					pal[j][l] = 1;
					if (l > maxLen)
					{
						maxLen = l;
						lastJ = j;
					}
				}
				else
				{
					pal[j][l] = 2;
				}
			}
		}
//		ObjectUtils.print(pal);
		String substring = s.substring(lastJ - maxLen / 2, lastJ + maxLen / 2 + 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < substring.length(); i++)
		{
			if (substring.charAt(i) != '#')
			{
				sb.append(substring.charAt(i));
			}
		}
//		System.out.println(sb.toString());
		return sb.toString();
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
