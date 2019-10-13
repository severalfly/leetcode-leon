package com.leon.leetcodeleon.q0.q07;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;

public class ReverseInteger
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
		assert reverse(i1) == 321;
		//		assert reverse(i2) == -321;
		//		assert reverse(i3) == 21;
		assert reverse(i4) == 0;
	}

	public int reverse(int x)
	{
		String s = Integer.toString(x);
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; x >= 0 ? i >= 0 : i > 0; i--)
		{
			sb.append(s.charAt(i));
		}
//		System.out.println(sb.toString());
		String maxInt = Integer.toString(Integer.MAX_VALUE);
		if (sb.toString().length() == maxInt.length() && sb.toString().compareTo(maxInt) > 0)
		{
			return 0;
		}
		int parseInt = Integer.parseInt(sb.toString());
		if (x < 0)
		{
			parseInt *= -1;
		}

		return parseInt;
	}
}
