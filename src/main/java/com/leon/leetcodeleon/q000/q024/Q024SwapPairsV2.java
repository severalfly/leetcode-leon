package com.leon.leetcodeleon.q000.q024;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

public class Q024SwapPairsV2
{

	@Test
	public void test()
	{
		ObjectUtils.printListNode(swapPairs(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4 })));
		ObjectUtils.printListNode(swapPairs(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 })));
		ObjectUtils.printListNode(swapPairs(ListNodeUtils.generateList(new int[] { 1 })));
		ObjectUtils.printListNode(swapPairs(ListNodeUtils.generateList(new int[] { 1, 2 })));
	}

	public ListNode swapPairs(ListNode head)
	{
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode h = res;

		while (h != null && h.next != null)
		{
			if (h.next.next == null)
			{
				break;
			}
			ListNode p = h.next;
			ListNode pp = h.next.next;
			p.next = pp.next;
			pp.next = p;
			h.next = pp;
			h = h.next.next;

		}
		return res.next;
	}

}
