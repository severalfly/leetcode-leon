package com.leon.leetcodeleon.q0.q02;

import lombok.Setter;
import lombok.Getter;
import org.junit.Test;

public class AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode res = new ListNode(-1);
		int carry = 0;
		ListNode corsor = res;
		while (l1 != null && l2 != null)
		{
			int i = l1.val + l2.val + carry;
			carry = i >= 10 ? 1 : 0;
			ListNode node = new ListNode(i % 10);
			node.next = null;
			res.next = node;
			res = res.next;

			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null)
		{
			int i = l1.val + carry;
			carry = i >= 10 ? 1 : 0;
			ListNode node = new ListNode(i % 10);
			node.next = null;
			res.next = node;
			res = res.next;
			l1 = l1.next;
		}

		while (l2 != null)
		{
			int i = l2.val + carry;
			carry = i >= 10 ? 1 : 0;
			ListNode node = new ListNode(i % 10);
			node.next = null;
			res.next = node;
			res = res.next;
			l2 = l2.next;
		}
		if (carry > 0)
		{
			ListNode node = new ListNode(1);
			node.next = null;
			res.next = node;
		}
		return corsor.next;
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


