package com.leon.leetcodeleon.q600.q680;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q680validPalindrome extends BaseTest
{
	@Test
	public void test()
	{
		assert validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
		assert validPalindrome("aba");
		assert validPalindrome("abca");
		assert validPalindrome("abcddccba");
	}

	public boolean validPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;
		// 是否还有可删除的机会
		while (left <= right)
		{
			char l = s.charAt(left);
			char r = s.charAt(right);
			if (l == r)
			{
				left++;
				right--;
				continue;
			}
			else
			{
				// 因为题目中提到有一次不相等的机会，尝试left++ 或者 right-- 是否相同，如果相同，则可以继续，否则，返回 false
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
		}
		return true;
	}

	public boolean isPalindrome(String s, int left, int right)
	{
		s = s.toLowerCase();
		while (left <= right)
		{
			char l = s.charAt(left);
			char r = s.charAt(right);
			if (l == r)
			{
				left++;
				right--;
				continue;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
}
