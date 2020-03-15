package com.leon.leetcodeleon.q0.q07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReverseIntegerV2
{
	private int i1 = 123;
	private int i2 = -123;
	private int i3 = 120;
	private int i4 = 2147483647;

	@Test
	public void testMaxInteger()
	{
		System.out.println(Integer.MAX_VALUE);
	}

	@Test
	public void test()
	{
		assert reverse(123) == 321;
		assert reverse(2147483647) == 0;
		assert reverse(-2147483412) == -2143847412;
	}

	public int reverse(int x)
	{
		int res = 0;
		while (x != 0)
		{
			if ((res * 10) / 10 != res)
				return 0;
			int i = x % 10;
			x = x / 10;

			res = res * 10 + i;
		}
		return res;
	}
}
