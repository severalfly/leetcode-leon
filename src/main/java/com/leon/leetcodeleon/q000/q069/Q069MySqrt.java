package com.leon.leetcodeleon.q000.q069;

import org.junit.Test;

public class Q069MySqrt
{
	@Test
	public void test()
	{
		assert mySqrt(8) == 2;
		assert mySqrt(5) == 2;
	}

	public int mySqrt(int x)
	{
		if (x <= 1)
		{
			return x;
		}
		long left = 1;
		long right = x / 2 + 1;
		while (left < right)
		{
			long mid = (left + right + 1) >> 1;
			if (mid * mid > x)
			{
				right = mid - 1;
			}
			else
			{
				left = mid;
			}
		}
		return (int) left;
	}
}
