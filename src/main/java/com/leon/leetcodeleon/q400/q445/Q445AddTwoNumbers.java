package com.leon.leetcodeleon.q400.q445;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.Stack;

public class Q445AddTwoNumbers
{
	@Test
	public void test()
	{
		ObjectUtils.printListNode(addTwoNumbers(ListNodeUtils.generateList(new int[] { 7, 2, 4, 3 }), ListNodeUtils.generateList(new int[] { 5, 6, 4 })));
		ObjectUtils.printListNode(addTwoNumbers(ListNodeUtils.generateList(new int[] { 7, 2, 4, 3 }), ListNodeUtils.generateList(new int[] { 6, 5, 6, 4 })));
		// ObjectUtils.printListNode(addTwoNumbers(ListNodeUtils.generateList(new int[] {}), ListNodeUtils.generateList(new int[] {})));
	}

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
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null)
		{
			stack1.add(l1.val);
			l1 = l1.next;
		}
		while (l2 != null)
		{
			stack2.add(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		ListNode head = null;
		while (stack1.size() > 0 || stack2.size() > 0)
		{
			int s1 = stack1.size() > 0 ? stack1.pop() : 0;
			int s2 = stack2.size() > 0 ? stack2.pop() : 0;
			int sum = s1 + s2 + carry;
			ListNode tmp = new ListNode(sum % 10);
			tmp.next = head;
			head = tmp;
			carry = sum / 10;
		}
		if (carry > 0)
		{
			ListNode tmp = new ListNode(1);
			tmp.next = head;
			head = tmp;
		}
		return head;

	}
}
