package com.leon.leetcodeleon.q000.q025;

import org.junit.Test;

public class Q025ReverseKGroup
{

	@Test
	public void test()
	{
		ListNode l1 = new ListNode(1);
		ListNode m = l1;
		m.next = new ListNode(2);
		m = m.next;
		m.next = new ListNode(3);
		m = m.next;
		m.next = new ListNode(4);
		m = m.next;
		m.next = new ListNode(5);
		m = m.next;
		m.next = new ListNode(6);
		//		m = m.next;
		//		m.next = new ListNode(7);
		//		m = m.next;
		//		m.next = new ListNode(8);
		//		m = m.next;
		//		m.next = new ListNode(9);
		//		m = m.next;
		//		m.next = new ListNode(10);
		printList(l1);

		ListNode l2 = new ListNode(1);
		m = l2;
		m.next = new ListNode(3);
		m = m.next;
		m.next = new ListNode(4);
		printList(l2);
		//
		ListNode l3 = new ListNode(2);
		printList(l3);

		//		printList(reverseKGroup(l1, 2));
		printList(reverseKGroup(l1, 3));
		printList(reverseKGroup(l3, 2));
	}

	public ListNode reverseKGroup(ListNode head, int k)
	{
		if (head == null)
		{
			return null;
		}
		ListNode tmp = new ListNode(0);
		tmp.next = head;
		ListNode first = head;
		ListNode per = tmp;
		while (head != null)
		{

			ListNode end = first;
			int i = k;
			while (i > 1 && end !=null &&  end.next != null)
			{
				end = end.next;
				i--;
			}
			if (i > 1 || end == null)
			{
				break;
			}
			ListNode ne = end.next;
			i = k;
			while (i > 1)
			{
				per.next = first.next;
				first.next = end.next;
				end.next = first;
				first = per.next;
				i--;
			}

			first = ne;

			i = k;
			while (i > 0)
			{
				per = per.next;
				i--;
			}

		}
		return tmp.next;
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
