package com.leon.leetcodeleon.q1300.q1390;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1390SumFourDivisors
{
	@Test
	public void test()
	{
		assert sumFourDivisors(new int[] { 21 }) == 32;
		// assert sumFourDivisors(new int[] { 1, 2, 3, 4, 5 }) == 0;
		// assert sumFourDivisors(new int[] { 21, 4, 7 }) == 32;
		assert sumFourDivisors(new int[] { 16 }) == 0;
		// assert sumFourDivisors(new int[] { 1000 }) == 0;
	}

	public int sumFourDivisors(int[] nums)
	{
		int res = 0;
		for (int num : nums)
		{
			res += helper(num);
		}
		return res;
	}

	private int helper(int num)
	{
		if (num >= -1 && num <= 1)
		{
			return 0;
		}
		int r = 0;
		int count = 0;
		for (int i = 1; i <= Math.sqrt(num); i++)
		{
			if (num % i == 0)
			{
				r += i;
				count++;
				int other = num / i;
				if (other != i)
				{
					r += other;
					count++;
				}
				if (count > 4)
					return 0;
			}
		}
		if (count != 4)
		{
			return 0;
		}
		return r;
	}

}
