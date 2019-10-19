package com.leon.leetcodeleon.q000.q024;

import com.leon.leetcodeleon.q000.q023.Q023MergeKLists;
import org.junit.Test;

public class Q024SwapPairs
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

		printList(swapPairs(l1));
		printList(swapPairs(l2));
		printList(swapPairs(l3));
	}

	public ListNode swapPairs(ListNode head)
	{
		//		ListNode tmp = new ListNode(0);
		//		tmp.next = head;
		ListNode res = head;
		ListNode first = null;
		ListNode second = null;
		ListNode per = null;
		while (head != null)
		{
			first = head;
			if (head.next == null)
			{
				break;
			}
			second = head.next;
			if (per != null)
			{
				per.next = second;
			}
			else
			{
				res = second;
			}

			first.next = second.next;
			second.next = first;
			head = head.next;
			per = first;

		}
		return res;
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
