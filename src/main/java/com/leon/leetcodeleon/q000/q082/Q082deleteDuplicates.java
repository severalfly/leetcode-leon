package com.leon.leetcodeleon.q000.q082;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q082deleteDuplicates
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
		while (head != null && head.next != null && head.val == head.next.val)
		{
			int k = head.val;
			while (head != null && head.val == k)
			{
				head = head.next;
			}
		}
		ListNode res = head;
		while (head != null && head.next != null)
		{
			int k = head.next.val;
			if (head.next.next != null && head.next.next.val == k)
			{
				ListNode tmp = head.next;
				while (tmp != null && tmp.val == k)
				{
					tmp = tmp.next;
				}
				head.next = tmp;
			}
			else
			{
				head = head.next;
			}
		}
		return res;
	}
}
