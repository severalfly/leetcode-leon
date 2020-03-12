package com.leon.leetcodeleon.q0.q02;

import org.junit.Test;

public class AddTwoNumbersV2
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if (l1 == null)
		{
			return l2;
		}
		if (l2 == null)
		{
			return l1;
		}
		int c = 0;
		ListNode res = new ListNode(0);
		ListNode h = res;
		while (l1 != null && l2 != null)
		{
			int k = l1.val + l2.val + c;
			if (k >= 10)
			{
				c = 1;
				k -= 10;
			}
			res.next = new ListNode(k);
			res = res.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null)
		{
			int k = l1.val + c;
			if (k >= 10)
			{
				c = 1;
				k -= 10;
			}
			res.next = new ListNode(k);
			res = res.next;
			l1 = l1.next;
		}
		while (l2 != null)
		{
			int k = l2.val + c;
			if (k >= 10)
			{
				c = 1;
				k -= 10;
			}
			res.next = new ListNode(k);
			res = res.next;
			l2 = l2.next;
		}
		return h.next;
	}

	@Test
	public void test()
	{
		ListNode node = new ListNode(2);
		ListNode node1 = new ListNode(4);
		node.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		ListNode nodeR = new ListNode(5);
		ListNode nodeR1 = new ListNode(6);
		nodeR.next = nodeR1;

		ListNode nodeR2 = new ListNode(4);
		nodeR1.next = nodeR2;
		ListNode node3 = addTwoNumbers(node, nodeR);

		while (node3 != null)
		{
			System.out.println(node3.val);
			node3 = node3.next;
		}

	}

	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}
}


