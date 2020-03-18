package com.leon.leetcodeleon.q0.q09;

import org.junit.Test;

public class IntegerIsPalindromeV2
{
	@Test
	public void test()
	{
		assert isPalindrome(121);
		assert !isPalindrome(-121);
		assert !isPalindrome(10);
		assert !isPalindrome(123);
		assert isPalindrome(0);
	}

	public boolean isPalindrome(int x)
	{
		String tmp = x + "";
		int l = 0;
		int r = tmp.length() - 1;
		while (l <= r)
		{
			if (tmp.charAt(l) != tmp.charAt(r))
			{
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
