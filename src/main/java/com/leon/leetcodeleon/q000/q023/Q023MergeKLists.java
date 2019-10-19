package com.leon.leetcodeleon.q000.q023;

import com.leon.leetcodeleon.common.BaseTest;
import org.junit.Test;

public class Q023MergeKLists extends BaseTest
{
	@Test
	public void test()
	{
		ListNode l1 = new ListNode(1);
		ListNode m = l1;
		m.next = new ListNode(4);
		m = m.next;
		m.next = new ListNode(5);
		printList(l1);

		ListNode l2 = new ListNode(1);
		m = l2;
		m.next = new ListNode(3);
		m = m.next;
		m.next = new ListNode(4);
		printList(l2);

		ListNode l3 = new ListNode(2);
		m = l3;
		m.next = new ListNode(6);
		printList(l3);

		ListNode[] array = new ListNode[] { l1, l2, l3 };
		ListNode listNode = mergeKLists(array);
		printList(listNode);
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		if (lists == null)
		{
			return null;
		}
		else if (lists.length == 1)
		{
			return lists[0];
		}
		return merge(lists, 0, lists.length - 1);

	}

	private ListNode merge(ListNode[] lists, int i, int i1)
	{
		if (i1 == i)
		{
			return lists[i];
		}
//		else if (i1 == i + 1)
//		{
//			return mergeTwoLists(lists[i1], lists[i]);
//		}
		else if (i1 >= i + 1)
		{
			int mid = (i1 + i) / 2;
			ListNode merge = merge(lists, i, mid);
			ListNode merge1 = merge(lists, mid + 1, i1);
			return mergeTwoLists(merge, merge1);
		}
		else
		{
			System.out.println("异常情况");
			return null;
		}
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
