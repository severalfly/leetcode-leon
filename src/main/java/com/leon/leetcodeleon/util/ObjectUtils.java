package com.leon.leetcodeleon.util;

import com.leon.leetcodeleon.common.ListNode;

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

	public static void printListNode(ListNode node)
	{
		ListNode listNode = node;
		while (listNode != null)
		{
			System.out.print(listNode.val);
			System.out.print(' ');
			listNode = listNode.next;
		}
		System.out.println();
	}
}
