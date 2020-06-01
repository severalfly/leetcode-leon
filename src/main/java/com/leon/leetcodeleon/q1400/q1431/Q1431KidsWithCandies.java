package com.leon.leetcodeleon.q1400.q1431;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.leon.leetcodeleon.q1400.q1431
 * @author zhangyunfei
 * @date 2020-06-01 21:04
 * @version V1.0
 */
public class Q1431KidsWithCandies
{
	@Test
	public void test()
	{
		System.out.println(kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
		System.out.println(kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1));
		System.out.println(kidsWithCandies(new int[] { 12, 1, 12 }, 10));
	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies)
	{
		int max = 0;
		for (int candy : candies)
		{
			if (candy > max)
			{
				max = candy;
			}
		}
		List<Boolean> res = new ArrayList<>(candies.length);
		for (int candy : candies)
		{
			res.add(candy + extraCandies >= max);
		}
		return res;
	}
}
