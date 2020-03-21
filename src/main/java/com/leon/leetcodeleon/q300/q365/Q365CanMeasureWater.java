package com.leon.leetcodeleon.q300.q365;

import org.junit.Test;

public class Q365CanMeasureWater
{
	@Test
	public void test()
	{
		assert canMeasureWater(3, 5, 4);
		assert !canMeasureWater(2, 6, 5);
	}

	public boolean canMeasureWater(int x, int y, int z)
	{
		if (x + y < z)
			return false;
		if (x == 0 || y == 0)
			return z == 0 || x + y == z;
		return z % gongYueShu(x, y) == 0;
	}

	public int gongYueShu(int x, int y)
	{
		int flag;
		if (x < y)
		{
			flag = x;
			x = y;
			y = flag;
		}
		while (y != 0)
		{
			int d = x % y;
			x = y;
			y = d;

		}
		return x;
	}

}
