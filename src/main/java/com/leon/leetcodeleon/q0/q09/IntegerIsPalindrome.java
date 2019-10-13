package com.leon.leetcodeleon.q0.q09;

import org.junit.Test;

public class IntegerIsPalindrome
{
	@Test
	public void test()
	{
		assert isPalindrome(121);
		assert !isPalindrome(-121);
		assert !isPalindrome(10);
		assert !isPalindrome(123);
	}

	public boolean isPalindrome(int x)
	{
		if(x ==0)
		{
			return true;
		}
		int org = x;
		if (x < 0 || x % 10 == 0)
		{
			return false;
		}
		int reverse = 0;
		while (x > 0)
		{
			int i = x % 10;
			reverse *= 10;
			reverse += i;
			x /= 10;
		}
		return org == reverse;
	}
}
