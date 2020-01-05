package com.leon.leetcodeleon.q000.q061;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q061RotateRight
{
	@Test
	public void test()
	{
		// ObjectUtils.printListNode(rotateRight(ListNodeUtils.generateList(new int[] {}), 1));
		ObjectUtils.printListNode(rotateRight(ListNodeUtils.generateList(new int[] { 0, 1, 2 }), 1));
		ObjectUtils.printListNode(rotateRight(ListNodeUtils.generateList(new int[] { 0, 1, 2 }), 2));
		ObjectUtils.printListNode(rotateRight(ListNodeUtils.generateList(new int[] { 0, 1, 2 }), 3));
		ObjectUtils.printListNode(rotateRight(ListNodeUtils.generateList(new int[] { 0, 1, 2 }), 4));
		ObjectUtils.printListNode(rotateRight(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 }), 2));
		ObjectUtils.printListNode(rotateRight(ListNodeUtils.generateList(new int[] { 7 }), 2));
	}

	public ListNode rotateRight(ListNode head, int k)
	{
		if (k <= 0 || head == null)
		{
			return head;
		}
		ListNode n = head;
		int len = 0;
		while (n != null)
		{
			len++;
			n = n.next;
		}
		ListNode tail = head;
		ListNode nhead = head.next;
		ListNode per = head;
		k = k % len;
		while (k > 0)
		{
			tail = tail.next;
			if (tail == null)
			{
				tail = head;
			}
			k--;
		}
		while (tail.next != null)
		{
			tail = tail.next;
			per = per.next;
			nhead = nhead.next;
		}
		if (nhead == null)
		{
			nhead = head;
		}
		tail.next = head;
		per.next = null;

		return nhead;
	}
}



