package com.leon.leetcodeleon.q500.q542;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q542UpdateMatrix extends BaseTest
{
	private int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	int[][] vis;
	private int row;
	private int col;
	private int[][] vector = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	@Test
	public void test()
	{
		ObjectUtils.print(updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
		ObjectUtils.print(updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }));
		ObjectUtils.print(updateMatrix(new int[][] {}));
	}

	public int[][] updateMatrix(int[][] matrix)
	{
		row = matrix.length;
		col = matrix[0].length;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (matrix[i][j] == 0)
				{
					// 将所有 0 元素作为 BFS 第一层
					queue.add(new int[] { i, j });
				}
				else
				{
					matrix[i][j] = row + col;
				}
			}
		}
		while (!queue.isEmpty())
		{
			int[] s = queue.poll();
			// 搜索上下左右四个方向
			for (int[] v : vector)
			{
				int r = s[0] + v[0], c = s[1] + v[1];
				if (r >= 0 && r < row && c >= 0 && c < col && matrix[r][c] > matrix[s[0]][s[1]] + 1)
				{
					matrix[r][c] = matrix[s[0]][s[1]] + 1;
					queue.add(new int[] { r, c });
				}
			}
		}
		return matrix;
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
					if (grid[nx][ny] == 0)
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
