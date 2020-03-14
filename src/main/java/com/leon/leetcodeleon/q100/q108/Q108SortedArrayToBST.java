package com.leon.leetcodeleon.q100.q108;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q108SortedArrayToBST
{
	@Test
	public void test()
	{
		TreeNodeUtils.printInOrder(sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));
	}

	public TreeNode sortedArrayToBST(int[] nums)
	{
		return helper(nums, 0, nums.length - 1);
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
