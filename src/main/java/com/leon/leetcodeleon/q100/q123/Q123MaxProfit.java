package com.leon.leetcodeleon.q100.q123;

import org.junit.Test;

public class Q123MaxProfit
{
	@Test
	public void test()
	{
		assert maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }) == 13;
		// assert maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }) == 6;
		// assert maxProfit(new int[] { 1, 2, 3, 4, 5 }) == 4;
		// assert maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0;
	}

	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length <= 0)
		{
			return 0;
		}
		// int res = 0;

		int[] tmp = new int[prices.length];
		int k = 0;
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++)
		{
			if (prices[i] < minPrice)
			{
				minPrice = prices[i];
			}
			else if (prices[i] - minPrice > maxProfit)
			{
				maxProfit = prices[i] - minPrice;
				if (i == prices.length - 1 || prices[i + 1] <= prices[i])
				{
					tmp[k++] = maxProfit;
					maxProfit = 0;
					minPrice = Integer.MAX_VALUE;
				}

			}
		}
		if (k < 2)
		{
			int res = 0;
			for (int i = 0; i < k; i++)
			{
				res += tmp[i];
			}
			return res;
		}
		int max = Integer.MIN_VALUE;
		int fMax = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++)
		{
			if (tmp[i] > max)
			{
				fMax = max;
				max = tmp[i];
			}
			else if (tmp[i] > fMax)
			{
				fMax = tmp[i];
			}
		}
		return max + fMax;
	}
}
