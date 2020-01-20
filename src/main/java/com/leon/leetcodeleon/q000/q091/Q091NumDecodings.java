package com.leon.leetcodeleon.q000.q091;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q091NumDecodings extends BaseTest
{
	@Test
	public void test()
	{
		assert numDecodings("12") == 2;
		assert numDecodings("226") == 3;
	}

	public int numDecodings(String s)
	{
		if (s.startsWith("0"))
		{
			return 0;
		}
		int per = 1;
		int cur = 1;
		for (int i = 1; i < s.length(); i++)
		{
			int tmp = cur;
			if ('0' == s.charAt(i))
			{
				if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
				{
					cur = per;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
				{
					cur += per;
				}
			}
			per = tmp;
		}
		return cur;
	}
}
