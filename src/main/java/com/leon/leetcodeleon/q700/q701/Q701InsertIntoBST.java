package com.leon.leetcodeleon.q700.q701;

import com.leon.leetcodeleon.common.TreeNode;
import com.leon.leetcodeleon.util.TreeNodeUtils;
import org.junit.Test;

/**
 * @Package com.leon.leetcodeleon.q700.q701
 * @author zhangyunfei
 * @date 2020-09-30 06:42
 * @version V1.0
 */
public class Q701InsertIntoBST
{
	@Test
	public void test()
	{
		TreeNode treeNode = insertIntoBST(TreeNodeUtils.generateTreeV2(new Integer[] { 4, 2, 7, 1, 3 }), 5);
		TreeNodeUtils.printInOrder(treeNode);
		// TreeNode treeNode1 = insertIntoBST(TreeNodeUtils.generateTreeV2(new Integer[] { 55, 28, 92, 26, 43, null, null, null, null, null, null }), 1);
		// TreeNodeUtils.printInOrder(treeNode1);
	}

	public TreeNode insertIntoBST(TreeNode root, int val)
	{

		if (root == null)
		{
			return new TreeNode(val);
		}
		TreeNode r = root;
		TreeNode t = new TreeNode(val);
		while (root.right != null || root.left != null)
		{

			if (root.val < val)
			{
				if (root.right == null)
				{
					// root.right = t;
					break;
				}
				else
					root = root.right;
			}
			if (root.val > val)
			{
				if (root.left == null)
				{
					// root.left = t;
					break;
				}
				else
					root = root.left;
			}
		}
		if (root.val > val)
		{
			root.left = t;
		}
		else
		{
			root.right = t;
		}
		return r;
	}

}
