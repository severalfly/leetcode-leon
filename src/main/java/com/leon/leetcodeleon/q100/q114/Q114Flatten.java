package com.leon.leetcodeleon.q100.q114;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.ObjectUtils;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

public class Q114Flatten
{
	@Test
	public void test()
	{
		TreeNode treeNode = TreeNodeUtils.generateTreeV2(new Integer[] { 1, 2, 5, 3, 4, null, 6 });
		TreeNode treeNode1 = treeNode;
		flatten(treeNode);
		TreeNodeUtils.printInOrder(treeNode1);
	}

	public void flatten(TreeNode root)
	{
		while (root != null)
		{
			TreeNode left = root.left;
			if (left != null)
			{
				TreeNode right = left;
				while (right.right != null)
				{
					right = right.right;
				}
				right.right = root.right;
				root.right = left;
				root.left = null;
			}
			root = root.right;
		}
		// System.out.println(1);
	}
}
