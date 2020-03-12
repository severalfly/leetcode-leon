package com.leon.leetcodeleon.q0.q03;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestStringV2 extends BaseTest
{
	@Test
	public void test()
	{
		assert lengthOfLongestSubstring("abcabcbb") == 3;
		assert lengthOfLongestSubstring("bbbbb") == 1;
		assert lengthOfLongestSubstring("pwwkew") == 3;
		assert lengthOfLongestSubstring("asjrgapa") == 6;
	}

	public int lengthOfLongestSubstring(String s)
	{
		Set<Character> set = new HashSet<>();
		int max = 0;
		int l = 0;
		int r = 0;
		while (r < s.length())
		{
			if (set.contains(s.charAt(r)))
			{
				while (set.contains(s.charAt(r)))
				{
					set.remove(s.charAt(l));
					l++;
				}
				set.add(s.charAt(r++));
			}
			else
			{
				set.add(s.charAt(r++));
			}
			if (r - l > max)
			{
				max = r - l;
			}
		}
		return max;
	}

}
