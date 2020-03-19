package com.leon.leetcodeleon.q400.q409;

import org.junit.Test;

public class Q409LongestPalindrome
{
	@Test
	public void test()
	{
		assert longestPalindrome("abccccdd") == 7;
		assert longestPalindrome("Aa") == 1;
		assert longestPalindrome("Aaaa") == 3;
	}

	public int longestPalindrome(String s)
	{
		if (s == null || s.length() <= 0)
		{
			return 0;
		}
		if (s.length() <= 1)
		{
			return 1;
		}
		int[] tmp = new int[52];
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c < 'Z')
			{
				// 由于限制了仅大小写字母，同时大写字母的 ascii 码较小
				tmp[c - 'A']++;
			}
			else
			{
				tmp[c - 'a' + 26]++;
			}
		}
		int res = 0;
		// 标记是否存在奇数
		boolean hasOdd = false;
		for (int i = 0; i < tmp.length; i++)
		{
			if (tmp[i] % 2 == 0)
			{
				res += tmp[i];
			}
			else
			{
				res += tmp[i] - 1;
				hasOdd = true;
			}
		}
		if (hasOdd)
		{
			res++;
		}
		return res;
	}
}
