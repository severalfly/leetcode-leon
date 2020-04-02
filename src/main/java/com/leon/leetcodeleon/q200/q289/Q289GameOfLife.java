package com.leon.leetcodeleon.q200.q289;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q289GameOfLife
{
	@Test
	public void test()
	{
		gameOfLife(new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } });
	}

	/**
	 * 需要新加两个状态，
	 * -1.之前是死，现在是活的，即从 0->-1
	 * 2.之前是活的，现在是死的，即从 1->2
	 * 最后循环一遍，把-1/2 转换成 0/1，即可结束
	 * @param board
	 */
	public void gameOfLife(int[][] board)
	{
		if (board.length <= 0 || board[0].length <= 0)
		{
			return;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int cnt = 0;

				for (int x = (i > 0 ? i - 1 : i); x <= (i < m - 1 ? (i + 1) : i); x++)
				{
					for (int y = (j > 0 ? j - 1 : j); y <= (j < n - 1 ? j + 1 : j); y++)
					{
						if (x == i && y == j)
						{
							continue;
						}
						if (board[x][y] == 1)
						{
							cnt++;
						}
						else if (board[x][y] == 2)
						{
							// 之前是活的
							cnt++;
						}
					}
				}
				if (board[i][j] == 1)
				{
					if (cnt < 2)
					{
						board[i][j] = 2;
					}
					else if (cnt <= 3)
					{
					}
					else
					{
						board[i][j] = 2;
					}
				}
				else
				{
					if (cnt == 3)
					{
						board[i][j] = -1;
					}
				}
			}
		}

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (board[i][j] == -1)
				{
					board[i][j] = 1;
				}
				else if (board[i][j] == 2)
				{
					board[i][j] = 0;
				}
			}
		}
		ObjectUtils.print(board);
	}
}
