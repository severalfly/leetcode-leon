package com.leon.leetcodeleon.q900.q914;

import org.junit.Test;

public class Q914HasGroupsSizeX
{
	@Test
	public void test()
	{
		assert hasGroupsSizeX(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 });
		assert !hasGroupsSizeX(new int[] { 1, 1, 1, 2, 2, 2, 3, 3 });
		assert !hasGroupsSizeX(new int[] { 1 });
		assert hasGroupsSizeX(new int[] { 1, 1 });
		assert hasGroupsSizeX(new int[] { 1, 1, 2, 2, 2, 2 });
	}

	public boolean hasGroupsSizeX(int[] deck)
	{
		int[] tmp = new int[10001];
		for (int i : deck)
		{
			tmp[i]++;
		}
		int x = 0;
		for (int i : tmp)
		{
			if (i > 0)
			{
				x = gcd(x, i);
				if (x == 1)
				{
					return false;
				}
			}
		}
		return true;
	}

	// 辗转相除法
	private int gcd(int a, int b)
	{
		return b == 0 ? a : gcd(b, a % b);
	}
}
