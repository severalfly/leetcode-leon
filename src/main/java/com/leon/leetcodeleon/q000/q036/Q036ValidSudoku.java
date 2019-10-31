package com.leon.leetcodeleon.q000.q036;

import org.junit.Test;

public class Q036ValidSudoku
{

	@Test
	public void test()
	{
		char[][] b1 = new char[9][9];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				b1[i][j] = '.';
			}
		}
		b1[0][0] = '5';
		b1[0][1] = '3';
		b1[3][0] = '8';
		print(b1);

		assert isValidSudoku(b1);
		char[][] b2 = b1;
		assert !isValidSudoku(b2);
	}

	public boolean isValidSudoku(char[][] board)
	{
		boolean[][] row = new boolean[9][9];
		boolean[][] column = new boolean[9][9];
		boolean[][] block = new boolean[9][9];

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] != '.')
				{
					int num = board[i][j] - '1';
					int blockIndex = i / 3 * 3 + j / 3;
					if (row[i][num] || column[j][num] || block[blockIndex][num])
					{
						return false;
					}
					else
					{
						row[i][num] = true;
						column[j][num] = true;
						block[blockIndex][num] = true;
					}
				}
			}
		}
		return true;
	}

	private void print(char[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				System.out.print(board[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
