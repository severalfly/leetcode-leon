package com.leon.leetcodeleon.mainshi.q13;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q13MovingCount
{
	@Test
	public void test()
	{
		assert movingCount(16, 8, 4) == 15;
		assert movingCount(11, 8, 16) == 88;
		assert movingCount(3, 2, 17) == 6;
		assert movingCount(2, 3, 1) == 3;
		assert movingCount(3, 1, 0) == 1;
		assert movingCount(0, 0, 0) == 0;
	}

	public int movingCount(int m, int n, int k)
	{
		if (m <= 0 || n <= 0 || k < 0)
		{
			return 0;
		}
		boolean[][] tmp = new boolean[m][n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		queue.add(0);
		int res = 0;
		while (queue.size() > 0)
		{
			int i = queue.poll();
			int j = queue.poll();

			if (tmp[i][j])
			{
				continue;
			}
			if (sum(i) + sum(j) <= k)
			{
				res++;
				tmp[i][j] = true;
			}
			else
			{
				continue;
			}

			int ni = i + 1;
			int nj = j;
			if (limit(ni, nj, m, n) && !tmp[ni][nj])
			{
				queue.add(ni);
				queue.add(nj);
			}
			ni = i;
			nj = j + 1;
			if (limit(ni, nj, m, n) && !tmp[ni][nj])
			{
				queue.add(ni);
				queue.add(nj);
			}

		}
		return res;
	}

	private int sum(int c)
	{
		int res = 0;
		while (c > 0)
		{
			int t = c % 10;
			res += t;
			c = c / 10;
		}
		return res;
	}

	private boolean limit(int i, int j, int m, int n)
	{
		if (i >= 0 && i < m && j >= 0 && j < n)
		{
			return true;
		}
		return false;
	}
}
