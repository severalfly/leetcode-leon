package com.leon.leetcodeleon.q200.q200;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q200NumIslands
{
	int[][] h;
	private int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	@Test
	public void test()
	{
		assert numIslands(new char[][] { "11110".toCharArray(), "11010".toCharArray(), "11000".toCharArray(), "00000".toCharArray() }) == 1;
		assert numIslands(new char[][] { "11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray() }) == 3;
	}

	public int numIslands(char[][] grid)
	{
		if (grid.length <= 0 || grid[0].length <= 0)
		{
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		h = new int[m][n];

		int res = 0;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (h[i][j] == 0 && grid[i][j] == '1')
				{
					res++;
					helper(grid, i, j, m, n, res);
				}
			}
		}
		print(h);
		return res;
	}

	void print(int[][] h)
	{
		ObjectUtils.print(h);
	}

	private void helper(char[][] grid, int i, int j, int m, int n, int res)
	{
		Queue<Integer> l = new LinkedList<>();
		l.add(i);
		l.add(j);
		while (l.size() > 0)
		{
			int ni = l.poll();
			int nj = l.poll();
			if (!limit(ni, nj, m, n) || h[ni][nj] > 0)
			{
				continue;
			}
			h[ni][nj] = res;
			for (int[] dir : direction)
			{
				int ti = ni + dir[0];
				int tj = nj + dir[1];
				if (limit(ti, tj, m, n) && grid[ti][tj] == '1' && h[ti][tj] == 0)
				{
					l.add(ti);
					l.add(tj);
				}
			}
		}
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
