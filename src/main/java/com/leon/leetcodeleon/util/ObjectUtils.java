package com.leon.leetcodeleon.util;

public class ObjectUtils
{
	public static void print(boolean[][] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				System.out.print(array[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	public static void print(int[][] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				System.out.print(array[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
