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
		return false;
	}

	private void print(char[][] b1)
	{
		for (int i = 0; i < b1.length; i++)
		{
			for (int j = 0; j < b1[0].length; j++)
			{
				System.out.print(b1[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
