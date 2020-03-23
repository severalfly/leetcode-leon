package com.leon.leetcodeleon.q800.q876;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q876MiddleNode
{
	@Test
	public void test()
	{
		ObjectUtils.printListNode(middleNode(ListNodeUtils.generateList(new int[] { 1 })));
		ObjectUtils.printListNode(middleNode(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 })));
		ObjectUtils.printListNode(middleNode(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5, 6 })));
	}

	public ListNode middleNode(ListNode head)
	{
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null)
		{
			if (fast.next == null)
			{
				return slow;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
