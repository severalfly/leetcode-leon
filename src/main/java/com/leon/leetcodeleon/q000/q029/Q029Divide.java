package com.leon.leetcodeleon.q000.q029;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q029Divide
{
	@Test
	public void test()
	{
				assert divide(2147483647, 3) == 715827882;
				assert divide(-2147483648, 1) == -2147483648;
		assert divide(-2147483648, -1) == 2147483647;
		assert divide(10, 3) == 3;
		assert divide(1, -1) == -1;
		assert divide(7, -3) == -2;
		assert divide(-7, 3) == -2;
		assert divide(1, 1) == 1;
		assert divide(1, -1) == -1;
	}

	public int divide(int dividend, int divisor)
	{

		boolean negtive = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		int a = dividend > 0 ? (-1 * dividend) : dividend;
		int b = divisor > 0 ? (-1 * divisor) : divisor;
		int ndiv = b;
		if (divisor == 0 || a > b)
		{
			return 0;
		}
		else if (a == b)
		{
			return negtive ? -1 : 1;
		}
		List<Integer> list = new ArrayList<>();
		while (a + 1 < ndiv)
		{
			a >>= 1;
			list.add(1);
		}
		if (a < ndiv)
		{
			list.add(0);
		}

		int res = 0;

		for (Integer i : list)
		{
			res = res * 2 + i;
		}
		while (a < ndiv)
		{
			res++;
			a -= ndiv;
		}
		//		if (a == ndiv)
		//		{
		//			res -= 1;
		//		}
		return negtive ? (-1 * res) : res;
	}

	public int divideV2(int dividend, int divisor)
	{
		boolean negtive = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		int a = dividend > 0 ? (-1 * dividend) : dividend;
		int b = divisor > 0 ? (-1 * divisor) : divisor;
		int ndiv = b;
		if (divisor == 0 || a > b)
		{
			return 0;
		}
		else if (a == b)
		{
			return negtive ? -1 : 1;
		}
		int n = 0;

		while (b > a)
		{
			b <<= 1;
			n++;
		}
		int res1 = -1 << (n - 1);
		int res2 = divide(a - (b >> 1), ndiv);

		int res = (Integer.MAX_VALUE - res2 > Math.abs(res1)) ? Integer.MAX_VALUE : ((negtive ? 1 : -1) * res1 + res2);
		return res;

	}
}
