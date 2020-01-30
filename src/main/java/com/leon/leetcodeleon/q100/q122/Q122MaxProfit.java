package com.leon.leetcodeleon.q100.q122;

import org.junit.Test;

public class Q122MaxProfit
{
	@Test
	public void test()
	{
		assert maxProfit(new int[] { 5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0 }) == 20;
		assert maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }) == 7;
		assert maxProfit(new int[] { 1,2,3,4,5 }) == 4;
		assert maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0;
	}

	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length <= 0)
		{
			return 0;
		}
		int res = 0;
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
					res += maxProfit;
					maxProfit = 0;
					minPrice = Integer.MAX_VALUE;
				}

			}
		}
		return res;
	}
}
