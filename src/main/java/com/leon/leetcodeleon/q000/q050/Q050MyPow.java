package com.leon.leetcodeleon.q000.q050;

import org.junit.Test;

public class Q050MyPow
{
	@Test
	public void test()
	{
		//		assert myPow(2.0, 10) == 1024;
		//		assert myPow(2.1, 3) == 9.261;
		assert myPow(2.0, -2) == 0.25;
	}

	public double myPow(double x, int n)
	{

		double pow = pow(x, n);
		System.out.println(pow);
		return pow;
	}

	private double pow(double a, int z)
	{
		if (a == 0.0f)
		{
			return 0.0f;
		}
		if (z == 0)
		{
			return 1;
		}
		if (z == 1)
		{
			return a;
		}
		if (z == -1)
		{
			return 1 / a;
		}
		int x = z / 2;
		double half = pow(a, x);
		double res = half * half * pow(a, z - x * 2);
		return res;
	}
}
