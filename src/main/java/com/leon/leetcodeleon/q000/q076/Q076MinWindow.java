package com.leon.leetcodeleon.q000.q076;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q076MinWindow
{
	@Test
	public void test()
	{
		assert minWindow("a", "aa").equalsIgnoreCase("");
		assert minWindow("a", "a").equalsIgnoreCase("a");
		assert minWindow("ADOBECODEBANC", "ABC").equalsIgnoreCase("BANC");
	}

	public String minWindow(String s, String t)
	{
		if (s == null || t == null || s.length() == 0 || t.length() == 0)
		{
			return "";
		}
		// Map<Character, Integer> orgMap = new HashMap<>();
		// for (int i = 0; i < s.length(); i++)
		// {
		// 	orgMap.put(s.charAt(i), orgMap.getOrDefault(s.charAt(i), 0) + 1);
		// }
		Map<Character, Integer> resMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++)
		{
			resMap.put(t.charAt(i), resMap.getOrDefault(t.charAt(i), 0) + 1);
		}
		int required = resMap.size();

		// 当前窗口中，已经出现的结果集中的字符数
		int formed = 0;

		int minLen = -1;
		int minLeft = 0;
		int minRight = 0;

		Map<Character, Integer> silMap = new HashMap<>();
		int left = 0;
		int right = 0;
		while (right < s.length())
		{
			char c = s.charAt(right);
			silMap.put(c, silMap.getOrDefault(c, 0) + 1);
			if (resMap.containsKey(c) && silMap.get(c).intValue() == resMap.get(c).intValue())
			{
				formed++;
			}
			while (left <= right && required == formed)
			{
				// 移动左侧，使最小
				c = s.charAt(left);
				if (minLen < 0 || right - left + 1 < minLen)
				{
					minLen = right - left + 1;
					minLeft = left;
					minRight = right;
				}
				silMap.put(c, silMap.get(c) - 1);
				if (resMap.containsKey(c) && silMap.get(c) < resMap.get(c))
				{
					formed--;
				}
				left++;

			}

			right++;
		}

		return minLen < 0 ? "" : (s.substring(minLeft, minRight + 1));
	}
}
