package com.leon.leetcodeleon.q000.q019;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q019RemoveNthFromEndV2 extends BaseTest
{
	@Test
	public void test()
	{

		ObjectUtils.printListNode(removeNthFromEnd(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 }), 1));
		ObjectUtils.printListNode(removeNthFromEnd(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 }), 2));
		ObjectUtils.printListNode(removeNthFromEnd(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 }), 5));
	}

	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		ListNode h = new ListNode(0);
		h.next = head;

		ListNode p = h;
		while (n > 0)
		{
			head = head.next;
			n--;
		}
		while (head != null)
		{
			p = p.next;
			head = head.next;
		}
		p.next = p.next.next;
		return h.next;
	}
}
