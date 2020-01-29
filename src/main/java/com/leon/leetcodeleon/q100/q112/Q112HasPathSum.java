package com.leon.leetcodeleon.q100.q112;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q112HasPathSum
{
	@Test
	public void test()
	{
		assert hasPathSum(TreeNodeUtils.generateTreeV2(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 }), 27);
	}

	public boolean hasPathSum(TreeNode root, int sum)
	{
		return depth(root, sum);
	}

	private boolean depth(TreeNode root, int sum)
	{
		if (root == null)
		{
			return false;
		}
		if (root.left == null && root.right == null && sum - root.val == 0)
		{
			return true;
		}
		boolean left = depth(root.left, sum - root.val);
		if (left)
		{
			return true;
		}
		boolean right = depth(root.right, sum - root.val);
		return right;

	}
}
