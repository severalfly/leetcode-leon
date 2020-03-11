package com.leon.leetcodeleon.q1100.q1103;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q1103DistributeCandies
{
	@Test
	public void test()
	{
		ObjectUtils.print(distributeCandies(4, 1));
		ObjectUtils.print(distributeCandies(1, 4));
		ObjectUtils.print(distributeCandies(7, 4));
		ObjectUtils.print(distributeCandies(10, 3));
	}

	public int[] distributeCandies(int candies, int num_people)
	{
		if (num_people <= 0)
		{
			return new int[0];
		}
		int[] res = new int[num_people];
		int e = 1;
		int i = 0;
		while (candies > 0)
		{
			if (candies < e)
			{
				// 最后一个，不够分了
				e = candies;
			}
			res[i++] += e;
			candies -= e;
			e++;
			if (i >= num_people)
			{
				i = i - num_people;
			}
		}
		return res;
	}
}
