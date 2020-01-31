package com.leon.leetcodeleon.q100.q125;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q125IsPalindrome extends BaseTest
{
	@Test
	public void test()
	{
		assert !isPalindrome("0P");
		assert isPalindrome("A man, a plan, a canal: Panama");
		assert !isPalindrome("race a car");
		assert isPalindrome("");

	}

	public boolean isPalindrome(String s)
	{
		s = s.toLowerCase();
		int left = 0;
		int right = s.length() - 1;
		while (left <= right)
		{
			char l = s.charAt(left);
			char r = s.charAt(right);
			if (!((l >= 'a' && l <= 'z') || (l >= '0' && l <= '9')))
			{
				left++;
				continue;
			}
			if (!((r >= 'a' && r <= 'z') || (r >= '0' && r <= '9')))
			{
				right--;
				continue;
			}
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
