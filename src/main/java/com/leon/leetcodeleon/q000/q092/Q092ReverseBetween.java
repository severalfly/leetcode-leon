package com.leon.leetcodeleon.q000.q092;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q092ReverseBetween
{
	@Test
	public void test()
	{
		ObjectUtils.printListNode(reverseBetween(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 }), 2, 4));
	}

	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		if (head == null)
		{
			return head;
		}

		return null;
	}
}
