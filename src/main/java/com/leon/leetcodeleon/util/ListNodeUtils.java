package com.leon.leetcodeleon.util;

import com.leon.leetcodeleon.common.ListNode;
import org.junit.Test;

public class ListNodeUtils
{
	public static ListNode generateList(int[] array)
	{
		if (array.length <= 0)
		{
			return null;
		}
		ListNode node = new ListNode(array[0]);
		ListNode n = node;
		for (int i = 1; i < array.length; i++)
		{

			n.next = new ListNode(array[i]);
			n = n.next;
		}
		return node;
	}

	@Test
	public void test()
	{
		ListNode listNode = generateList(new int[] { 1, 3, 4 });
		ObjectUtils.printListNode(listNode);
	}

}
