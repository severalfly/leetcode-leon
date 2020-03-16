package com.leon.leetcodeleon.mainshi.q0106;

import org.junit.Test;

public class Q0106CompressString
{
	@Test
	public void test()
	{
		assert compressString("a").equalsIgnoreCase("a");
		assert compressString("aa").equalsIgnoreCase("aa");
		assert compressString("aaaaaaaaaaa").equalsIgnoreCase("a11");
		assert compressString("aabcccccaaa").equalsIgnoreCase("a2b1c5a3");
		assert compressString("aabcccccaaaa").equalsIgnoreCase("a2b1c5a4");
		assert compressString("aabccccca").equalsIgnoreCase("a2b1c5a1");
		assert compressString("abbccd").equalsIgnoreCase("abbccd");
	}

	public String compressString(String S)
	{
		if (S.length() <= 0)
		{
			return "";
		}
		StringBuilder sb = new StringBuilder();
		char c = S.charAt(0);
		sb.append(c);
		int n = 1;
		for (int i = 1; i < S.length(); i++)
		{
			if (S.charAt(i) == c)
			{
				n++;
			}
			else
			{
				// 不相等，需要考虑是否合并
				sb.append(n);
				if (sb.length() >= S.length())
				{
					return S;
				}
				c = S.charAt(i);
				sb.append(c);
				n = 1;
			}
		}
		sb.append(n);
		if (sb.length() >= S.length())
		{
			return S;
		}
		return sb.toString();
	}
}
