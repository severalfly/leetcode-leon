package com.leon.leetcodeleon.q100.q110;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q110IsBalanced
{
	@Test
	public void test()
	{
		assert isBalanced(TreeNodeUtils.generateTreeV2(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
		assert !isBalanced(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 2, 3, 3, null, null, 4, 4 }));
	}

	public boolean isBalanced(TreeNode root)
	{
		return depth(root) != -1;
	}

	private int depth(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		int left = depth(root.left);
		if (left == -1)
		{
			return -1;
		}
		int right = depth(root.right);
		if (right == -1)
		{
			return -1;
		}
		return Math.abs(right - left) < 2 ? Math.max(left, right) + 1 : -1;
	}
}
