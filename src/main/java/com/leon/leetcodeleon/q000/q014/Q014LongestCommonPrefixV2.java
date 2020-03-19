package com.leon.leetcodeleon.q000.q014;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q014LongestCommonPrefixV2 extends BaseTest
{
	@Test
	public void test()
	{
		assert longestCommonPrefix(new String[] { "flower", "flow", "flight" }).equalsIgnoreCase("fl");
		assert longestCommonPrefix(new String[] { "dog", "racecar", "car" }).equalsIgnoreCase("");
		assert longestCommonPrefix(new String[] { "aa", "a" }).equalsIgnoreCase("a");
	}

	public String longestCommonPrefix(String[] strs)
	{
		if (strs == null || strs.length <= 0)
		{
			return "";
		}

		int res = 0;
		for (int i = 0; i < strs[0].length(); i++)
		{
			char c = strs[0].charAt(i);
			for (String str : strs)
			{
				if (i >= str.length() || c != str.charAt(i))
				{
					return strs[0].substring(0, res);
				}
			}
			res = i + 1;
		}
		return strs[0].substring(0, res);
	}
}
