package com.leon.leetcodeleon.q000.q058;

import org.junit.Test;

public class Q058LengthOfLastWord
{
	@Test
	public void test()
	{
		// assert lengthOfLastWord("Hello World") == 5;
		assert lengthOfLastWord("a  ") == 1;
		assert lengthOfLastWord(" ab  ") == 2;
	}

	public int lengthOfLastWord(String s)
	{
		if (s == null || s.length() == 0)
		{
			return 0;
		}
		int lastLen = 0;
		boolean last = true;
		for (int i = s.length() - 1; i >= 0; i--)
		{
			if (s.charAt(i) == ' ')
			{
				if (last)
				{
					continue;
				}
				break;
			}
			lastLen++;
			last = false;
		}
		return lastLen;
	}
}
