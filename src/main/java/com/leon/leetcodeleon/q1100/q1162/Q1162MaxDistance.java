package com.leon.leetcodeleon.q1100.q1162;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q1162MaxDistance extends BaseTest
{
	private int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	int[][] vis;
	int[][] res;

	@Test
	public void test()
	{
		assert maxDistance(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }) == 2;
		assert maxDistance(new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }) == 4;
		assert maxDistance(new int[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 0, 0, 0 } }) == 2;
		assert maxDistance(new int[][] { { 0, 0, 1, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 } }) == 2;
		assert maxDistance(new int[][] { { 1, 0, 1, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 } }) == 1;
	}

	public int maxDistance(int[][] grid)
	{
		ObjectUtils.print(grid);
		// int max = Integer.MIN_VALUE;
		int m = grid.length;
		int n = grid[0].length;
		this.vis = new int[m][n];
		int ans = -1;
		for (int i = 0; i < m; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				if (grid[i][j] == 0)
				{
					ans = Math.max(ans, findNearestLand(grid, i, j, m, n));
				}
			}
		}
		System.out.println(ans);
		return ans;

	}

	int findNearestLand(int[][] grid, int x, int y, int m, int n)
	{
		this.vis = new int[m][n];
		Queue<T> q = new LinkedList<>();
		q.add(new T(x, y, 0));
		vis[x][y] = 1;
		while (q.size() > 0)
		{
			T f = q.poll();
			for (int i = 0; i < 4; ++i)
			{
				int nx = f.x + direction[i][0], ny = f.y + direction[i][1];
				if (!limit(nx, ny, m, n))
					continue;
				if (vis[nx][ny] == 0)
				{
					// q.push({ nx, ny, f.step + 1 });
					q.add(new T(nx, ny, f.step + 1));
					vis[nx][ny] = 1;
					if (grid[nx][ny] == 1)
						return f.step + 1;
				}
			}
		}
		return -1;
	}

	class T
	{
		int x;
		int y;
		int step;

		T(int x, int y, int step)
		{
			this.x = x;
			this.y = y;
			this.step = step;
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
