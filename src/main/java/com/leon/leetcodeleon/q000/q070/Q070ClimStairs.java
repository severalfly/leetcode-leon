package com.leon.leetcodeleon.q000.q070;

import org.junit.Test;

public class Q070ClimStairs
{
	@Test
	public void test()
	{
		assert climbStairs(2) == 2;
		assert climbStairs(3) == 3;
		assert climbStairs(4) == 5;
		assert climbStairs(5) == 8;
	}

	public int climbStairs(int n)
	{
		if (n <= 2)
		{
			return n;
		}
		int p = 1;
		int q = 2;
		for (int i = 3; i <= n; i++)
		{
			int tmp = p + q;
			p = q;
			q = tmp;
		}
		return q;
	}
}
