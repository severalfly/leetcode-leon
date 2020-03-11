package com.leon.leetcodeleon.q000.q098;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q098IsValidBST
{
	@Test
	public void test()
	{
		assert !isValidBST(TreeNodeUtils.generateTreeV2(new Integer[] { 10, 5, 15, null, null, 6, 20 }));
		assert !isValidBST(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 1 }));
		assert isValidBST(TreeNodeUtils.generateTreeV2(new Integer[] { 2, 1, 3 }));
		assert !isValidBST(TreeNodeUtils.generateTreeV2(new Integer[] { 5, 1, 4, null, null, 3, 6 }));
	}

	public boolean isValidBST(TreeNode root)
	{
		return help(root, null, null);
	}

	public boolean help(TreeNode root, Integer lower, Integer upper)
	{
		if (root == null)
		{
			return true;
		}
		int val = root.val;
		if (lower != null && lower >= val)
		{
			return false;
		}
		if (upper != null && upper <= val)
		{
			return false;
		}
		if (!help(root.left, lower, val))
		{
			return false;
		}
		if (!help(root.right, val, upper))
		{
			return false;
		}
		return true;
	}
}
