package com.leon.leetcodeleon.q100.q134;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q134canCompleteCircuit extends BaseTest
{
	@Test
	public void test()
	{
		assert canCompleteCircuit(new int[] { 5, 1, 2, 3, 4 }, new int[] { 4, 4, 1, 5, 1 }) == 4;
		assert canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }) == 3;
		assert canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }) == -1;
	}

	public int canCompleteCircuit(int[] gas, int[] cost)
	{
		if (gas == null || gas.length <= 0)
		{
			return -1;
		}
		int sumg = 0;
		int sumc = 0;
		for (int i = 0; i < gas.length; i++)
		{
			sumg += gas[i];
			sumc += cost[i];
		}
		if (sumc > sumg)
		{
			// 总消耗量大于总油量，说明肯定不能一圈
			return -1;
		}
		// 执行到此处，说明总消耗量小于总油量，一定是有一个结果的，那么，一旦某个站遍历之后，就不需要再考虑了，因为：
		// 如果此站之前不满足，那么后面的站一定有充足的油量保证总油量大于总消耗

		// 开始的加油站
		int start = 0;
		// 当前加油站
		int cur = 0;
		// 当前剩余的油量
		int left = 0;
		while (cur < gas.length)
		{
			if (gas[cur] < cost[cur])
			{
				cur++;
				continue;
			}
			start = cur;
			while (cur < gas.length && left + gas[cur] - cost[cur] >= 0)
			{
				left += gas[cur] - cost[cur];
				cur++;
			}
			if (cur == gas.length)
			{
				break;
			}
			else
			{
				// 不满足条件的，要清空剩余量
				left = 0;
			}
		}

		return start;
	}
}
