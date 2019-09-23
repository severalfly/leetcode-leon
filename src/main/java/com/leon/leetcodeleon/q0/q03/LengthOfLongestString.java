package com.leon.leetcodeleon.q0.q03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestString
{
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null || s.length() == 0)
		{
			return 0;
		}
		int size, i = 0, j, k, max = 0;
		size = s.length();
		for (j = 0; j < size; j++)
		{
			for (k = i; k < j; k++)
				if (s.charAt(k) == s.charAt(j))
				{
					i = k + 1;
					break;
				}
			if (j - i + 1 > max)
				max = j - i + 1;
		}
		return max;
		//		return Math.max(max1, max2);
	}

	@Test
	public void test()
	{
		//		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		//		System.out.println(lengthOfLongestSubstring("bbbbb"));
		//		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("asjrgapa"));
	}
}
