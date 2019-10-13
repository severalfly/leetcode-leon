package com.leon.leetcodeleon.q000.q014;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q014LongestCommonPrefix extends BaseTest
{
	@Test
	public void test()
	{
		assert longestCommonPrefix(new String[] { "flower", "flow", "flight" }).equalsIgnoreCase("fl");
	}

	public String longestCommonPrefix(String[] strs)
	{
		if (strs == null || strs.length <= 0)
		{
			return "";
		}
		int minLen = strs[0].length();
		for (String str : strs)
		{
			if (str.length() < minLen)
			{
				minLen = str.length();
			}
		}
		for (int i = 0; i < minLen; i++) // 最长的长度
		{
			char c = strs[0].charAt(i);
			for (String str : strs)
			{
				if (str.charAt(i) != c)
				{
					return i > 0 ? strs[0].substring(0, i) : "";
				}
			}
		}
		return strs[0].substring(0, minLen);
	}
}
