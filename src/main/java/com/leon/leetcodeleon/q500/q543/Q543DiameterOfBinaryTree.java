package com.leon.leetcodeleon.q500.q543;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q543DiameterOfBinaryTree
{
	private int max = 0;

	@Test
	public void test()
	{
		assert diameterOfBinaryTree(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3 })) == 2;
		assert diameterOfBinaryTree(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3, 4, 5 })) == 3;
	}

	public int diameterOfBinaryTree(TreeNode root)
	{
		help(root, 0);
		return max;
	}

	public int help(TreeNode root, int h)
	{
		if (root == null)
		{
			return 0;
		}
		int l = 0;
		if (root.left != null)
		{
			l += help(root.left, h);
		}
		int r = 0;
		if (root.right != null)
		{
			r += help(root.right, h);
		}
		int sum = l + r;
		if (sum > max)
		{
			max = sum;
		}
		return Math.max(l, r) + 1;
	}
}
