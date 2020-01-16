package com.leon.leetcodeleon.q000.q086;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q086Partition
{
	@Test
	public void test()
	{
		ObjectUtils.printListNode(partition(ListNodeUtils.generateList(new int[] { 4 }), 3));
		ObjectUtils.printListNode(partition(ListNodeUtils.generateList(new int[] { 1 }), 3));
		ObjectUtils.printListNode(partition(ListNodeUtils.generateList(new int[] { 1, 4, 3, 2, 5, 2 }), 3));
	}

	public ListNode partition(ListNode head, int x)
	{
		if (head == null || head.next == null)
		{
			return head;
		}
		ListNode before = new ListNode(-1);
		ListNode after = new ListNode(-1);

		ListNode b = before;
		ListNode a = after;

		while (head != null)
		{
			if (head.val < x)
			{
				before.next = head;
				before = before.next;
			}
			else
			{
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		after.next = null;
		before.next = a.next;

		return b.next;
	}
}
