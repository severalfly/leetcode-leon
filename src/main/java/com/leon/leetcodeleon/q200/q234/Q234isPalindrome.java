package com.leon.leetcodeleon.q200.q234;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import org.junit.Test;

public class Q234isPalindrome
{
	@Test
	public void test()
	{
		assert !isPalindrome(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
		assert !isPalindrome(ListNodeUtils.generateList(new int[] { 1, 2 }));
		assert isPalindrome(ListNodeUtils.generateList(new int[] { 1, 2, 2, 1 }));
		assert isPalindrome(ListNodeUtils.generateList(new int[] { 1 }));
	}

	public boolean isPalindrome(ListNode head)
	{
		// 我们选择比较风骚的解法
		if (head == null )
		{
			return true;
		}
		ListNode h = head;
		int len = 0;
		while (h != null)
		{
			h = h.next;
			len++;
		}
		if (len == 1)
		{
			return true;
		}
		// end 为前半部分的末尾
		ListNode end = head;
		for (int i = 0; i < len / 2 - 1; i++)
		{
			// 注意，
			end = end.next;
		}
		h = end;

		ListNode p = h.next;
		ListNode pp = p.next;
		h.next = null;
		while (p != null)
		{
			if (p.next != null)
			{
				// ListNode pp = p.next;
				p.next = h;

				h = p;
				p = pp;
				pp = pp.next;
			}
			else
			{
				p.next = h;
				h = p;
				p = null;
			}
		}

		ListNode f = head;
		ListNode b = h;

		for (int i = 0; i < len / 2; i++)
		{
			if (f.val != b.val)
			{
				return false;
			}
			f = f.next;
			b = b.next;
		}

		// todo 需要恢复后半部分的顺序，虽然题目中未要求恢复
		return true;
	}
}
