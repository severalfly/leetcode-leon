package com.leon.leetcodeleon.q000.q025;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.ObjectUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q025ReverseKGroupV2
{

	@Test
	public void test()
	{
		ObjectUtils.printListNode(reverseKGroup(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 }), 2));
		ObjectUtils.printListNode(reverseKGroup(ListNodeUtils.generateList(new int[] { 1, 2, 3, 4, 5 }), 3));
	}

	public ListNode reverseKGroup(ListNode head, int k)
	{
		// if (head == null)
		// {
		// 	return null;
		// }
		// List<ListNode> tmp = new ArrayList<>(k);
		// ListNode pre = new ListNode(0);
		// pre.next = head;
		// ListNode p = pre;
		//
		// while (head != null)
		// {
		// 	tmp = new ArrayList<>(k);
		// 	int i = k;
		// 	while (head != null && i > 0)
		// 	{
		// 		tmp.add(head);
		// 		i--;
		// 		head = head.next;
		// 	}
		// 	if (tmp.size() < k)
		// 	{
		// 		break;
		// 	}
		// 	tmp.get(0).next = tmp.get(k - 1).next;
		// 	for (i = k - 1; i > 0; i--)
		// 	{
		// 		tmp.get(i).next = tmp.get(i);
		// 	}
		// 	p.next = tmp.get(k - 1);
		// 	p = tmp.get(0);
		// 	head = p.next;
		// }
		// return pre.next;
		return null;
	}

}
