package com.leon.leetcodeleon.q900.q999;

import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q999NumRookCaptures
{
	@Test
	public void test()
	{
		assert numRookCaptures(
				new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' }, { '.', '.', '.', 'R', '.', '.', '.', 'p' }, { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
						{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } }) == 3;
		assert numRookCaptures(
				new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' }, { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' }, { '.', 'p', 'B', 'R', 'B', 'p', '.', '.' }, { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' }, { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
						{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } }) == 0;
		assert numRookCaptures(
				new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' }, { 'p', 'p', '.', 'R', '.', 'p', 'B', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'B', '.', '.', '.', '.' },
						{ '.', '.', '.', 'p', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } }) == 3;
	}

	public int numRookCaptures(char[][] board)
	{
		ObjectUtils.print(board);
		int m = board.length;
		int n = board[0].length;
		int ni = -1;
		int nj = -1;
		for (int i = 0; i < m; i++)
		{
			boolean find = false;
			for (int j = 0; j < n; j++)
			{
				if (board[i][j] == 'R')
				{
					find = true;
					ni = i;
					nj = j;
					break;
				}
			}
		}
		int res = 0;
		for (int i = ni - 1; i >= 0; i--)
		{
			if (board[i][nj] == 'B')
			{
				break;
			}
			else if (board[i][nj] == 'p')
			{
				res++;
				break;
			}
		}
		for (int i = ni + 1; i < m; i++)
		{
			if (board[i][nj] == 'B')
			{
				break;
			}
			else if (board[i][nj] == 'p')
			{
				res++;
				break;
			}
		}

		for (int j = nj - 1; j >= 0; j--)
		{
			char c = board[ni][j];
			if (c == 'B')
			{
				break;
			}
			else if (c == 'p')
			{
				res++;
				break;
			}
		}
		for (int j = nj + 1; j < n; j++)
		{
			char c = board[ni][j];
			if (c == 'B')
			{
				break;
			}
			else if (c == 'p')
			{
				res++;
				break;
			}
		}
		return res;
	}
}
