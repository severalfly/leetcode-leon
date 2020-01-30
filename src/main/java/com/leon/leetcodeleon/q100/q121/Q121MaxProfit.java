package com.leon.leetcodeleon.q100.q121;

import org.junit.Test;

public class Q121MaxProfit
{
	@Test
	public void test()
	{
		assert maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }) == 5;
		assert maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0;
	}

	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length <= 0)
		{
			return 0;
		}
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
			}
		}
		return maxProfit;
	}
}
