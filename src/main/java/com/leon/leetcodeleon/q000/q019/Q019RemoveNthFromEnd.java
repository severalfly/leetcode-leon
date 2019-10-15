package com.leon.leetcodeleon.q000.q019;

import org.junit.Test;

public class Q019RemoveNthFromEnd
{
	@Test
	public void test()
	{
		ListNode n = new ListNode(1);
		ListNode m = n;
		for (int i = 2; i < 3; i++)
		{
			m.next = new ListNode(i);
			m = m.next;
		}

		printList(n);
		//		n = n.next;
		//		printList(n);
		ListNode listNode = removeNthFromEnd(n, 1);
		printList(listNode);
	}

	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		ListNode h = head;
		ListNode d = null;
		while (n > 0)
		{
			head = head.next;
			n--;
		}
		d = h;
		if (head == null)
		{
			return h.next;
		}
		while (head.next != null)
		{
			head = head.next;
			d = d.next;
		}
		if (d.next == null)
		{
			return null;
		}
		d.next = d.next.next;

		return h;
	}

	private class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}

	private void printList(ListNode l)
	{
		StringBuilder sb = new StringBuilder();
		while (l != null)
		{
			sb.append(l.val);
			sb.append("-");
			l = l.next;
		}
		System.out.println(sb);
	}
}
