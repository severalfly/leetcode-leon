package com.leon.leetcodeleon.q000.q021;

import com.leon.leetcodeleon.q000.q019.Q019RemoveNthFromEnd;
import org.junit.Test;

public class Q021MergeTwoList
{
	@Test
	public void test()
	{
		ListNode l1 = new ListNode(1);
		ListNode m = l1;
		m.next = new ListNode(2);
		m = m.next;
		m.next = new ListNode(4);
		printList(l1);

		ListNode l2 = new ListNode(1);
		m = l2;
		m.next = new ListNode(3);
		m = m.next;
		m.next = new ListNode(4);
		printList(l2);

		ListNode listNode = mergeTwoLists(l1, l2);
		printList(listNode);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		if (l1 == null)
		{
			return l2;
		}
		else if (l2 == null)
		{
			return l1;
		}
		ListNode res = null;
		if (l1.val <= l2.val)
		{
			res = new ListNode(l1.val);
			l1 = l1.next;
		}
		else
		{
			res = new ListNode(l2.val);
			l2 = l2.next;
		}
		ListNode t = res;
		// 开始执行合并
		while (l1 != null && l2 != null)
		{
			if (l1.val <= l2.val)
			{
				res.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else
			{
				res.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			res = res.next;
		}
		while (l1 != null)
		{
			res.next = new ListNode(l1.val);
			l1 = l1.next;
			res = res.next;
		}
		while (l2 != null)
		{
			res.next = new ListNode(l2.val);
			l2 = l2.next;
			res = res.next;
		}

		return t;
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
