package com.leon.leetcodeleon.q000.q083;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q083DeleteDuplicates
{
	@Test
	public void test()
	{
		ObjectUtils.printListNode(deleteDuplicates(ListNodeUtils.generateList(new int[] { 1, 1, 2 })));
		ObjectUtils.printListNode(deleteDuplicates(ListNodeUtils.generateList(new int[] { 1, 1, 2, 2 })));
		ObjectUtils.printListNode(deleteDuplicates(ListNodeUtils.generateList(new int[] { 1, 1 })));
		ObjectUtils.printListNode(deleteDuplicates(ListNodeUtils.generateList(new int[] { 1 })));
		ObjectUtils.printListNode(deleteDuplicates(ListNodeUtils.generateList(new int[] { 1, 2, 3, 3, 4, 4, 5 })));
		ObjectUtils.printListNode(deleteDuplicates(ListNodeUtils.generateList(new int[] { 1, 1, 1, 2, 3 })));
	}

	public ListNode deleteDuplicates(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode res = head;
		while (head.next != null)
		{
			int k = head.val;
			if (head.next.val == k)
			{
				while (head.next != null && head.next.val == k)
				{
					head.next = head.next.next;
				}
			}
			else
			{
				head = head.next;
			}
		}
		return res;
	}
}
