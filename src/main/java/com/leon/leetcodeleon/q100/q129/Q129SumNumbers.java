package com.leon.leetcodeleon.q100.q129;

import com.leon.leetcodeleon.common.BaseTest;
import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q129SumNumbers extends BaseTest
{
	@Test
	public void test()
	{
		assert sumNumbers(TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 3 })) == 25;
		assert sumNumbers(TreeNodeUtils.generateTreeV2(new Integer[] { 4, 9, 0, 5, 1 })) == 1026;
	}

	public int sumNumbers(TreeNode root)
	{
		return helper(root, 0);
	}

	public int helper(TreeNode root, int path)
	{
		if (root == null)
		{
			return 0;
		}
		int res = path;
		if (root.left == null && root.right == null)
		{
			// 叶子节点
			res += root.val;
			return res;
		}
		path += root.val;
		path *= 10;
		int r1 = helper(root.left, path);
		int r2 = helper(root.right, path);

		path /= 10;

		return r1 + r2;
	}
}
