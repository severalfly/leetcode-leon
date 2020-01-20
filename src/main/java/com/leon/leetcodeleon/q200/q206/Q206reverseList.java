package com.leon.leetcodeleon.q200.q206;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q206reverseList
{
	@Test
	public void test()
	{
		ObjectUtils.printListNode(reverseList(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 })));
		ObjectUtils.printListNode(reverseList(ListNodeUtils.generateList(new int[] { 1, 2 })));
	}

	public ListNode reverseList(ListNode head)
	{

		ListNode per = null;
		ListNode cur = head;
		while (cur != null)
		{
			ListNode nextTmp = cur.next;
			cur.next = per;
			per = cur;

			cur = nextTmp;
		}
		return per;
	}
}
