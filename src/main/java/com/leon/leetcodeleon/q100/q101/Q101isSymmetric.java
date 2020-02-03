package com.leon.leetcodeleon.q100.q101;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q101isSymmetric extends BaseTest
{
	@Test
	public void test()
	{
		assert isSymmetric(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 2, 3, 4, 4, 3 }));
		assert !isSymmetric(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 2, null, 3, null, 3 }));
	}

	public boolean isSymmetric(TreeNode root)
	{
		if (root == null)
		{
			return true;
		}
		return isMorror(root.left, root.right);
	}

	public boolean isMorror(TreeNode left, TreeNode right)
	{
		if (left == null && right == null)
		{
			return true;
		}
		if (left == null || right == null)
		{
			return false;
		}
		return left.val == right.val && isMorror(left.right, right.left) && isMorror(left.left, right.right);
	}
}
