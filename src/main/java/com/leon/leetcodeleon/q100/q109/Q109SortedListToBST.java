package com.leon.leetcodeleon.q100.q109;

import com.leon.leetcodeleon.common.ListNode;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.ListNodeUtils;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q109SortedListToBST
{
	@Test
	public void test()
	{
		TreeNodeUtils.printInOrder(sortedListToBST(ListNodeUtils.generateList(new int[] { -10, -3, 0, 5, 9 })));
	}

	public TreeNode sortedListToBST(ListNode head)
	{
		int len = 0;
		ListNode h = head;
		while (head != null)
		{
			len++;
			head = head.next;
		}
		int[] nums = new int[len];
		int k = 0;
		while (h != null)
		{
			nums[k++] = h.val;
			h = h.next;
		}
		return helper(nums, 0, len - 1);
	}

	public TreeNode helper(int[] nums, int s, int e)
	{
		if (s > e)
		{
			return null;
		}
		int mid = (e + s) / 2;
		if ((e + s) % 2 == 1)
		{
			mid++;
		}
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, s, mid - 1);
		root.right = helper(nums, mid + 1, e);
		return root;
	}
}
