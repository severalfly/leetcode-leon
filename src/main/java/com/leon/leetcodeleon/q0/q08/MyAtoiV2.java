package com.leon.leetcodeleon.q0.q08;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyAtoiV2
{
	@Test
	public void test()
	{
		assert myAtoi("2147483648") == 2147483647;
		assert myAtoi("42") == 42;
		assert myAtoi("   -42") == -42;
		assert myAtoi("4193 with words") == 4193;
		assert myAtoi("words and 987") == 0;
		assert myAtoi("-91283472332") == -2147483648;
		assert myAtoi("-6147483648") == -2147483648;
	}

	public int myAtoi(String str)
	{
		if (str == null || str.length() <= 0 || str.trim().length() <= 0)
		{
			return 0;
		}
		str = str.trim();
		char flat = ' ';
		if (str.startsWith("-") || str.startsWith("+"))
		{
			flat = str.charAt(0);
			str = str.substring(1);
		}
		int res = 0;
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (c >= '0' && c <= '9')
			{
				if ((res * 10) / 10 != res || res * 10 > Integer.MAX_VALUE - (c - '0'))
				{
					return flat == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}

				res = res * 10 + (c - '0');

			}
			else
			{
				if (i == 0)
					return 0;
				else
				{
					break;
				}
			}
		}
		return flat == '-' ? -1 * res : res;
	}
}
