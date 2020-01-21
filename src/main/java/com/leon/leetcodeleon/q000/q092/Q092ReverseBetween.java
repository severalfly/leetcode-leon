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
		ObjectUtils.printListNode(reverseBetween(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5, 6 }), 3, 6));
		ObjectUtils.printListNode(reverseBetween(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5, 6 }), 1, 6));
		ObjectUtils.printListNode(reverseBetween(ListNodeUtils.generateList(new int[] { 1 }), 1, 1));
	}

	public ListNode reverseBetween(ListNode head, int m, int n)
	{

		if (head == null)
		{
			return head;
		}
		ListNode p = new ListNode(0);
		p.next = head;
		ListNode h = p;
		m++;
		n++;
		while (m - 2 > 0)
		{
			h = h.next;
			m--;
			n--;
		}
		ListNode per = h;
		ListNode cur = h.next;
		ListNode nextTmp = null;
		ListNode f = null;
		while (cur != null && n - 1 > 0)
		{
			if (f == null)
			{
				f = cur;
			}
			nextTmp = cur.next;
			cur.next = per;
			per = cur;

			h.next = cur;
			f.next = nextTmp;

			cur = nextTmp;
			n--;
		}

		return p.next;
	}
}
