package com.leon.leetcodeleon.q900.q983;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q900.q983
 * @author zhangyunfei
 * @date 2020/5/6 08:00
 * @version V1.0
 */
public class Q983MincostTickets
{
	@Test
	public void test()
	{
		assert mincostTickets(new int[] { 1, 3, 7 }, new int[] { 1, 4, 20 }) == 3;
		assert mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }) == 11;
		assert mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }) == 17;
	}

	public int mincostTickets(int[] days, int[] costs)
	{
		if (days == null || days.length == 0)
		{
			return 0;
		}
		int[] dp = new int[days[days.length - 1] + 1];
		for (int num : days)
		{
			dp[num] = Integer.MAX_VALUE;
		}
		// 首先按第一天为1天的通行证计算
		for (int i = 1; i < dp.length; i++)
		{
			if (dp[i] == 0)
			{
				dp[i] = dp[i - 1];
				continue;
			}

			int t1 = dp[i - 1] + costs[0];
			int t2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
			int t3 = i > 30 ? dp[i - 30] + costs[2] : costs[2];
			dp[i] = Math.min(t1, Math.min(t2, t3));
		}
		print(dp);
		return dp[dp.length - 1];
	}

	private void print(int[] dp)
	{
		ObjectUtils.print(dp);
	}
}
