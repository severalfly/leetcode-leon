package com.leon.leetcodeleon.q1000.q1071;

import org.junit.Test;

public class Q1071GcdOfStrings
{
	@Test
	public void test()
	{
		assert gcdOfStrings(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
				.equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assert gcdOfStrings("ABC", "A").equals("");
		assert gcdOfStrings("AAA", "A").equals("A");
		assert gcdOfStrings("ABCABC", "ABC").equals("ABC");
		assert gcdOfStrings("ABABAB", "ABAB").equals("AB");
		assert gcdOfStrings("LEET", "CODE").equals("");
		assert gcdOfStrings("", "CODE").equals("");
		assert gcdOfStrings("LEFT", "").equals("");
		assert gcdOfStrings("", "").equals("");
	}

	public String gcdOfStrings(String str1, String str2)
	{
		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
		{
			return "";
		}
		int l1 = str1.length();
		int l2 = str2.length();
		String s1 = str1;
		String s2 = str2;
		if (l1 < l2)
		{
			// 始终保持 s2 的长度不超过s1，
			s1 = str2;
			s2 = str1;
		}
		// 最大结果
		int len = s2.length();

		while (s2.length() < s1.length())
		{
			s2 += s2;
		}
		s2 += s2;
		int g = gongYueShu(l1, l2);

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < len; i += g)
		{
			res.append(s2.substring(i, i + g));
			if (s1.equals(s2.substring(i, i + s1.length())))
			{
				// return res.reverse().toString();
				return res.toString();
			}
		}
		return "";
	}

	@Test
	public void testGongyueshu()
	{
		System.out.println(gongYueShu(3, 6));
		System.out.println(gongYueShu(2, 6));
		System.out.println(gongYueShu(4, 6));
		System.out.println(gongYueShu(1, 6));
	}

	public int gongYueShu(int x, int y)
	{
		int flag;
		if (x < y)
		{
			flag = x;
			x = y;
			y = flag;
		}
		while (y != 0)
		{
			int d = x % y;
			x = y;
			y = d;

		}
		return x;
	}

}
