package com.leon.leetcodeleon.mainshi.q0811;

import org.junit.Test;

public class Q0811WaysToChange
{
	int mod = 1000000007;

	@Test
	public void test()
	{
		assert waysToChange(5) == 2;
		assert waysToChange(10) == 4;
	}

	public int waysToChange(int n)
	{
		long ans = 0;
		for (int i = 0; i * 25 <= n; ++i)
		{
			int rest = n - i * 25;
			int a = rest / 10;
			int b = rest % 10 / 5;
			ans = (ans + (long) (a + 1) * (a + b + 1) % mod) % mod;
		}
		return (int) ans;

	}
}
