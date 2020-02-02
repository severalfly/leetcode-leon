package com.leon.leetcodeleon.q100.q135;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q135Candy extends BaseTest
{
	@Test
	public void test()
	{
		// assert candy(new int[] { 1, 2, 3 }) == 6;
		// assert candy(new int[] { 1, 0, 2 }) == 5;
		assert candy(new int[] { 1, 2, 3, 4, 2, 1, 5 }) == 15;
		// assert candy(new int[] { 1, 2, 2 }) == 4;
	}

	public int candy(int[] ratings)
	{
		if (ratings == null || ratings.length <= 0)
		{
			return 0;
		}
		int f = 0;
		int s = 0;
		int sum = 0;
		int n = 1;
		while (f < ratings.length)
		{
			if (ratings[f] < ratings[f + 1])
			{
				// 增长趋势
				sum += n;
				n++;
				s++;
				f++;
			}
			else
			{
				// 非增趋势，就比较麻烦了，可以采用
				n--;
				sum += n;
				f++;
				while (f < ratings.length && ratings[f] > ratings[f + 1])
				{
					sum += n;
					n--;
					f++;
				}
			}
			f++;
		}
		return sum;
	}
}
