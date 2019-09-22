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
		List<Set<Character>> list = new ArrayList<>();
		Set<Character> sb = new HashSet<>();
		sb.add(s.charAt(0));
		list.add(sb);
		for (int i = 1; i < s.length(); i++)
		{
			if (!sb.contains(s.charAt(i)))
			{
				sb.add(s.charAt(i));
				//				continue;
			}
			else
			{
				list.add(sb);
				sb = new HashSet<>();
				sb.add(s.charAt(i));
			}
		}
		list.add(sb);

		int max1 = 0;
		for (Set<Character> stringBuffer : list)
		{
			if (stringBuffer.size() > max1)
			{
				max1 = stringBuffer.size();
			}
		}

		list = new ArrayList<>();
		sb = new HashSet<>();
		sb.add(s.charAt(s.length() - 1));
		list.add(sb);
		for (int i = s.length() - 2; i > 0; i--)
		{
			if (!sb.contains(s.charAt(i)))
			{
				sb.add(s.charAt(i));
				//				continue;
			}
			else
			{
				list.add(sb);
				sb = new HashSet<>();
				sb.add(s.charAt(i));
			}
		}
		list.add(sb);

		int max2 = 0;
		for (Set<Character> stringBuffer : list)
		{
			if (stringBuffer.size() > max2)
			{
				max2 = stringBuffer.size();
			}
		}

		return Math.max(max1, max2);
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
